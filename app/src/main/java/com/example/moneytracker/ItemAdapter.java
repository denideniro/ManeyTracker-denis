package com.example.moneytracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Item> data = new ArrayList<>();

//    public ItemAdapter() {
//        createData();
//    }
    public void setData(List<Item> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public  ItemAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ItemViewHolder holder, int position) {
        Item record = data.get(position);
        holder.applyData(record);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

//    private void createData() {
//        data.add(new Item("Молоко", 35));
//        data.add(new Item("Жизнь", 25000));
//        data.add(new Item("", 0));
//        data.add(new Item("Курсы", 10000));
//        data.add(new Item("Хлеб", 15));
//        data.add(new Item("Тот самый ужин когда я разорился", 3000));
//        data.add(new Item("На пивко", 200));
//        data.add(new Item("С пацанами на приколы", 200));
//        data.add(new Item("На интернет", 150));
//        data.add(new Item("На Драгобрат", 7000));
//        data.add(new Item("На одежду", 5000));
//        data.add(new Item("На стики", 3000));
//    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView price;

        public ItemViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }

        public void applyData(Item item) {
            title.setText(item.name);
            price.setText(String.valueOf(item.price));
        }
    }
}
