package com.example.try1;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.ProgrammingViewholder>{

    private ArrayList<String> editors = new ArrayList<>();
    private ArrayList<String> images = new ArrayList<>();
    private ArrayList<String> section = new ArrayList<>();
    private Context context;

    public ProgrammingAdapter(ArrayList<String> editors, ArrayList<String> images, ArrayList<String> section, Context context) {
        this.editors = editors;
        this.images = images;
        this.context = context;
        this.section = section;
    }

    @NonNull
    @Override
    public ProgrammingViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        ProgrammingViewholder holder = new ProgrammingViewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewholder holder, final int position) {
      Glide.with(context).asBitmap().load(images.get(position)).into(holder.imgIcon);

      holder.Editors.setText(editors.get(position));
      holder.Sections.setText(section.get(position));

      holder.parentLayout.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){

            Intent intent = new Intent(context, newsActivity.class);
            intent.putExtra("image_url", images.get(position));
            intent.putExtra("Section", section.get(position));
            context.startActivity(intent);
        }
      });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ProgrammingViewholder extends RecyclerView.ViewHolder {
        ImageView imgIcon;
        TextView Editors, Sections;
        Button Read_more;
        String tocarry;
        LinearLayout parentLayout;

        public ProgrammingViewholder(@NonNull View itemView) {             //holding views to serve on screen
            super(itemView);
            imgIcon = (ImageView) itemView.findViewById(R.id.imageView2);
            Editors = (TextView) itemView.findViewById(R.id.textView3);
            Sections = (TextView) itemView.findViewById(R.id.textView5);
            parentLayout = (LinearLayout) itemView.findViewById(R.id.layout_id);
        }
    }
}
