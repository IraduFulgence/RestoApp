package com.example.myapplication;

import android.app.Activity;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

class MyDishView {
    public static class MyListAdapter extends ArrayAdapter<String> {
        private Activity context;
        private String[] FOODSNAMES;
        private String[] FOODSDETAILS;
        private Integer[] IMAGES;
        public MyListAdapter(Activity context, String[] FOODSNAMES, String[] FOODSDETAILS, Integer[] IMAGES) {
            super( context,R.layout.kib,FOODSNAMES);
            this.context=context;
            this.FOODSNAMES =FOODSNAMES;
            this.FOODSDETAILS = FOODSDETAILS;
            this.IMAGES = IMAGES;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            View kibb = layoutInflater.inflate(R.layout.kib,null);
            TextView tv = (TextView)kibb.findViewById(R.id.tv1);
            TextView tvv = (TextView)kibb.findViewById(R.id.tv2);
            ImageView imageView= (ImageView)kibb.findViewById(R.id.image);
            imageView.setImageResource(IMAGES[position]);
            tv.setText(FOODSNAMES[position]);
            tvv.setText(FOODSDETAILS[position]);

            return kibb;
        }


        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }
            return true;
        }
    }
}
