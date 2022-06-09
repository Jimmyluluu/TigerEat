package com.example.tigereatapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RequiresApi(api = Build.VERSION_CODES.O)
public class EditInfoActivity extends AppCompatActivity {

    private Button btnConfirm;
    private ImageView ivEditPhoto;
    private ImageView ivPhoto;
    private ImageView ivCamera;
    private EditText etName;
    private TextView tvEmail;
    private EditText etPhone;
    private EditText etAddress;
    private String imagePath;
    private String imageType = ".jpg";
    private DatabaseReference mDatabase;
    private FirebaseStorage storage;
    private Bitmap bitmap = null;
    BitmapFactory.Options bfoOptions = new BitmapFactory.Options();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);

        ivPhoto = findViewById(R.id.ivSetPhoto);
        ivEditPhoto = findViewById(R.id.ivEditInfoPhoto);
        btnConfirm = findViewById(R.id.btnConfirm);
        ivCamera = findViewById(R.id.ivCamera);
        etName = findViewById(R.id.etEditName);
        tvEmail = findViewById(R.id.tvShowEmail);
        etPhone = findViewById(R.id.etEditPhone);
        etAddress = findViewById(R.id.etEditAddress);

        //取得firebase storage
        storage = FirebaseStorage.getInstance();

        getInfos();

        ivPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // requestmanageexternalstorage_Permission();

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
                openCamera();
                Log.i("state", "cameraOpen");
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInfo();
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        getStorePermission();
        getCameraPermission();
        Log.i("state", "getPermission");
    }

    private void getInfos() {

        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference infoRef = mDatabase.child("costomers").child(User.account);
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                String email = dataSnapshot.child("email").getValue(String.class);
                String name = dataSnapshot.child("name").getValue(String.class);
                String phone = dataSnapshot.child("phone").getValue(String.class);
                String address = dataSnapshot.child("address").getValue(String.class);
                if (email != null) {
                    Log.i("email", email);
                    tvEmail.setText(email);
                }
                if (name != null) {
                    Log.i("name", name);
                    etName.setText(name);
                }
                if (phone != null) {
                    Log.i("phone", phone);
                    etPhone.setText(phone);
                }
                if (address != null) {
                    Log.i("address", address);
                    etAddress.setText(address);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        infoRef.addValueEventListener(postListener);
    }

    private void setInfo() {

        try {
            mDatabase = FirebaseDatabase.getInstance().getReference();
            DatabaseReference infoRef = mDatabase.child("costomers").child(User.account);

            Map<String, Object> user = new HashMap<>();
            user.put("email", String.valueOf(tvEmail.getText()));
            user.put("name", String.valueOf(etName.getText()));
            user.put("phone", String.valueOf(etPhone.getText()));
            user.put("address", String.valueOf(etAddress.getText()));
            infoRef.updateChildren(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            if (resultCode == RESULT_OK && null != data) {
                if (requestCode == 1) {
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

                    Log.i("ul", "bf");
                    upload();
                    Log.i("ul", "af");
                } else if (requestCode == 2) {
                    Log.i("open", "camera");
                    Bundle extras = data.getExtras();
                    bitmap = (Bitmap) extras.get("data");
                    Log.i("bm", String.valueOf(bitmap));
                    imageType = ".jpg";
                    Log.i("ul", "bf");
                    cameraUpload();
                    Log.i("ul", "af");
                }
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

    private void upload() {

        //建立時戳
        Long tsLong = System.currentTimeMillis() / 1000;
        String ts = tsLong.toString();
        //要圖片的新檔名
        String picname = User.account + "-" + ts + imageType;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("infopic").child(User.account).setValue(picname);
        Log.i("picname", picname);
        //更新檔名
        //要上傳到遠端路徑
        StorageReference imageRef = storage.getReference()
                .child("images").child(User.account).child(picname);
        Log.i("imageRef", imageRef.toString());
        byte[] dataUpdate = null ;
        Log.i("dud", "");
        if (imagePath.indexOf(".gif") > -1) {
            Log.i("gif", "in");
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(imagePath);
                dataUpdate = new byte[fis.available()];
                fis.read(dataUpdate);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Log.i("image", "notGif");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Log.i("bao", "");
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            Log.i("bitmap", "");
            dataUpdate = baos.toByteArray();
        }

        UploadTask uploadTask = imageRef.putBytes(dataUpdate);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
                Log.e("upload", "fail");
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                // ...
                Log.i("upload", "success");
            }
        });

        Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                if (!task.isSuccessful()) {
                    throw task.getException();
                }
                // Continue with the task to get the download URL
                return imageRef.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if (task.isSuccessful()) {
                    Uri downloadUri = task.getResult();
                    User.photoUri = downloadUri.toString();
                    Log.i("download", downloadUri.toString());
                } else {
                    Log.i("dtask", "fail");
                }
            }
        });
    }

    private void cameraUpload() {

        //建立時戳
        Long tsLong = System.currentTimeMillis() / 1000;
        String ts = tsLong.toString();
        //要圖片的新檔名
        String picname = User.account + "-" + ts + imageType;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("infopic").child(User.account).setValue(picname);
        Log.i("picname", picname);
        //更新檔名
        //要上傳到遠端路徑
        StorageReference imageRef = storage.getReference()
                .child("images").child(User.account).child(picname);
        Log.i("imageRef", imageRef.toString());
        // byte[] dataUpdate = null ;
        // Log.i("gif", String.valueOf(imagePath.indexOf(".gif")));
        Log.i("dud", "dataUpdate.toString()");
        /*if (imagePath.indexOf(".gif") > -1) {
            Log.i("gif", "in");
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(imagePath);
                dataUpdate = new byte[fis.available()];
                fis.read(dataUpdate);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Log.i("image", "notGif");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Log.i("bao", "");
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            Log.i("bitmap", "");
            dataUpdate = baos.toByteArray();
        }*/
        Log.i("image", "notGif");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Log.i("bao", "");
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        Log.i("bitmap", "");
        byte[] dataUpdate = baos.toByteArray();

        UploadTask uploadTask = imageRef.putBytes(dataUpdate);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
                Log.e("upload", "fail");
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                // ...
                Log.i("upload", "success");
            }
        });

        Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                if (!task.isSuccessful()) {
                    throw task.getException();
                }
                // Continue with the task to get the download URL
                return imageRef.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if (task.isSuccessful()) {
                    Uri downloadUri = task.getResult();
                    User.photoUri = downloadUri.toString();
                    Log.i("download", downloadUri.toString());
                } else {
                    Log.i("dtask", "fail");
                }
            }
        });
    }

    private void getCameraPermission() {

        boolean cameraHasGone = checkSelfPermission(Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] permissions = new String[1];;
            if (!cameraHasGone) {//如果相機權限未取得
                permissions[0] = Manifest.permission.CAMERA;
            } else {
                Log.i("permi", "權限已取得");
                return;
            }
            requestPermissions(permissions, 100);
        }
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