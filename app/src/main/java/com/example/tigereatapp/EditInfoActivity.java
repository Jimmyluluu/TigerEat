package com.example.tigereatapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.loader.content.CursorLoader;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditInfoActivity extends AppCompatActivity {

    private Button btnConfirm;
    private ImageView ivEditPhoto;
    private ImageView ivPhoto;
    private ImageView ivCamera;
    String imagePath;
    String imageType = ".jpg";
    Bitmap bitmap = null;
    BitmapFactory.Options bfoOptions = new BitmapFactory.Options();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);

        ivPhoto = findViewById(R.id.ivSetPhoto);
        ivEditPhoto = findViewById(R.id.ivEditInfoPhoto);
        btnConfirm = findViewById(R.id.btnConfirm);
        ivCamera = findViewById(R.id.ivCamera);

        ivPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // requestmanageexternalstorage_Permission();

                getStorePermission();

                Intent intent = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });

        ivCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("state", "onClick");
                Log.i("state", "getPermission");
                openCamera();
                Log.i("state", "cameraOpen");
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etName = findViewById(R.id.etEditName);
                TextView tvEmail = findViewById(R.id.tvShowEmail);
                EditText etPhone = findViewById(R.id.etEditPhone);
                EditText etAddress = findViewById(R.id.etEditAddress);
                finish();
            }
        });
    }

    private void getStorePermission() {

        boolean externalHasGone = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] permissions = new String[1];
            if (!externalHasGone) {//如果權限未取得
                permissions[0] = Manifest.permission.WRITE_EXTERNAL_STORAGE;
            } else {
                Log.i("permi", "權限已取得");
                return;
            }
            requestPermissions(permissions, 100);
        }
    }

    /*private void requestmanageexternalstorage_Permission() {
        // 登录后复制
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // 先判断有没有权限
            if (Environment.isExternalStorageManager()) {
                Toast.makeText(this, "Android VERSION R OR ABOVE, HAVE MANAGE_EXTERNAL_STORAGE GRANTED!", Toast.LENGTH_LONG).show();
                Log.i("permission", "true");
            } else {
                Toast.makeText(this, "Android VERSION R OR ABOVE, NO MANAGE EXTERNAL_STORAGE GRANTED!", Toast.LENGTH_LONG).show();
                Log.i("permission", "false");
                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                intent.setData(Uri.parse("package:" + this.getPackageName()));
                startActivityForResult(intent,0);
                Log.i("permission", "true");
            }
        }
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        try {
            if (requestCode == 1 && resultCode == RESULT_OK && null != data) {
                Toast.makeText(this, "Success to pick image", Toast.LENGTH_LONG).show();
                Log.i("pick image", "success");
                // 這邊便可以對輸入的 data 進行我們想要做的處理
                //getLocalMediaUri();

                Uri uri = data.getData();//uri identifier
                Log.i("uri", uri.toString());
                if (DocumentsContract.isDocumentUri(this, uri)) {
                    String docId = DocumentsContract.getDocumentId(uri);
                    Log.i("docId", docId);

                    // 到各資料夾下找
                    if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                        //Fill in code by yourself
                        String id = docId.split(":")[1];
                        String selection = MediaStore.Images.Media._ID + "=" + id;
                        imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
                        Log.i("imagePath", imagePath);

                    } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                        //Fill in code by yourself
                        Uri contentUri = ContentUris.withAppendedId(
                                Uri.parse("content://downloads/public_downloads"),
                                Long.valueOf(docId));
                        imagePath = getImagePath(contentUri, null);
                        Log.i("imagePath", imagePath);
                    }
                } else if ("content".equalsIgnoreCase(uri.getScheme())) {
                    //Fill in code by yourself
                    imagePath = getImagePath(uri, null);
                    Log.i("imagePath", imagePath);
                }
                //判斷圖片型態
                if (imagePath.indexOf(".jpg") > -1) {
                    imageType = ".jpg";
                } else if (imagePath.indexOf(".png") > -1) {
                    imageType = ".png";
                } else if (imagePath.indexOf(".gif") > -1) {
                    imageType = ".gif";
                }
                //選擇的圖片轉換成bitmap
                bitmap = BitmapFactory.decodeFile(imagePath, bfoOptions);
                ivEditPhoto.setImageBitmap(bitmap);
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something wrong", Toast.LENGTH_LONG).show();
            Log.i("pick image", "fail");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @SuppressLint("Range")
    private String getImagePath(Uri uri, String selection) {//isolated
        String path = null;
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    public void openCamera(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, 2);
            /*String sd_path = Environment.getExternalStorageDirectory().getPath() + "/InfoPhotos/";
            SimpleDateFormat format = new SimpleDateFormat("yyyymmddhhmmss");
            String filename = format.format(new Date(System.currentTimeMillis())) + ".jpg";
            photoPath = sd_path + filename;
            File file = new File(photoPath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }*/
        } catch (ActivityNotFoundException e) {
            // display error state to the user
            e.printStackTrace();
        }
    }
}