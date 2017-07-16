package edu.gsu.httpcs.finalproject.util;

import android.content.Context;
import android.graphics.Bitmap;

import com.squareup.picasso.Transformation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by YoungH on 3/24/17.
 */

//Default path: /data/<PackageName>/files
//Mode: MODE_PRIVATE（default：override、MODE_APPEND：append

public class UtilFile {
    public static void save(Context context, String data, String name) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = context.openFileOutput(name, Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String load(Context context, String name){
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try{
            in = context.openFileInput(name);
            reader = new BufferedReader(new InputStreamReader(in));
            String line= "";
            while((line = reader.readLine()) != null){
                builder.append(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try{
                    reader.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return builder.toString();
        }

    }


public static class CropSquareTransformation implements Transformation {
    @Override public Bitmap transform(Bitmap source) {
        int size = Math.min(source.getWidth(), source.getHeight());
        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;
        Bitmap result = Bitmap.createBitmap(source, x, y, size, size);
        if (result != source) {
            source.recycle();
        }
        return result;
    }

    @Override public String key() { return "square()"; }
}
}
