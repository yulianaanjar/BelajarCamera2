package com.yagmail.anjaryuliana.belajarcamera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

// import android.content.Intent dan  import android.os.Bundle; adalah Source Code Bahasa Pemrograman Android yang di gunakan
// untuk membaca Data dengan  tipe berbentuk String, angka (integer, float, double), ArrayList, boolean, array, character, dan
// sebagainya, jadi Fungsi untuk memasukan atau memanggil data - data tersebut.


// import android.view.View; adalah digunakan untuk Menampilkan data - data untuk menampilkan platform pada sebuah Gadget
// Seperti Menu - yang terdapat pada Aplikasi Android tersebut 


// import android.widget.ImageButton; Merupakan Sebuah Source Code Untuk Memanggil dan Menampilkan Sebuah Widget pada
// Program Android yang menggunakan Imang atau Gambar dengan tampilkan gambar tersebut dapat diklik atau di link ke Widget
// yang lainnya.

public class MainActivity extends AppCompatActivity {
    //pada perintah diatas digunakan untuk menfeklarasikan class MainActivity

    ImageView imageView;
    //mendeklarasikan variable imageView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //  Protected di gunakan untuk Menyatakan bahwa kelas/method/attribute tersebut dapat diakses oleh kelas lain yang berada
        // dalam satu package atau kelas lain tersebut merupakan turunannya. Fungsi Protected ini sama dengan Public, hanya dapat
        // digunakan dalam Class yang sama

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCamera = (Button) findViewById(R.id.button);
        // Kode diatas,kita mendeklarasikan “btnCamera” dari Button yang dipanggil melalui findViewById .

        imageView = findViewById(R.id.imageView);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         // menunjukkan kondisi yang aktif ketika terekam atau terjadi Click pada Button “btnCamera” .

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //perintah untuk meluncurkan action kamera
                startActivityForResult(takePictureIntent, 0);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        //Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
        //imageView.setImageBitmap(imageBitmap);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(imageBitmap);
            }
        }

    }
}
