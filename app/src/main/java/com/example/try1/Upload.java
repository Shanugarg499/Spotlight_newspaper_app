package com.example.try1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Upload extends AppCompatActivity {

//    String user= getIntent().getExtras().toString();
    Button ch, up;
    TextView text;
    public Uri uri;
    ProgressDialog progressDialog;
    StorageReference mStorageRef;
    public Firebase mRef;
    //final String name = getIntent().getStringExtra("user");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        Firebase.setAndroidContext(this);
        mRef=new Firebase("https://try1-15512.firebaseio.com/");
        mStorageRef= FirebaseStorage.getInstance().getReference("Uploads");
        ch=(Button)findViewById(R.id.selectfile);
        up=(Button)findViewById(R.id.upload);
        text=(TextView)findViewById(R.id.notification);
        ch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Filechooser();
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fileuploader();
            }
        });

    }
//
//    private String Fileextension(){
//        ContentResolver cr=getContentResolver();
//        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
//        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
//    }

    private void Fileuploader() {

        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("See progress here:");
        progressDialog.setProgress(0);
        progressDialog.show();
        final String name = getIntent().getStringExtra("user");
        final StorageReference ref = mStorageRef.child(name+".pdf");
        ref.putFile(uri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(final UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {

                                final Uri downloadUrl = uri;

                                Firebase mRefChild = mRef.child(name);
                                mRefChild.setValue(downloadUrl.toString());

                                progressDialog.dismiss();
                                Toast.makeText(Upload.this, "File uploaded successfully😊", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        Toast.makeText(Upload.this, "File didn't upload successfully😢 with exception: " + exception.toString(), Toast.LENGTH_SHORT).show();
                        // ...
                    }
                })
        .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {

                int update = (int)(taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount())*100;
                progressDialog.setProgress(update);

            }
        });

    }

    private void Filechooser() {
        Intent intent=new Intent();
//        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
             uri=data.getData();
             text.setText("File selected : "+data.getData().getLastPathSegment());
            }
    }
}
