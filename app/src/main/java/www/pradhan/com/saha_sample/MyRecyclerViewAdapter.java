/*
 * Copyright (c) 2017. Truiton (http://www.truiton.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * Mohit Gupt (https://github.com/mohitgupt)
 *
 */

package www.pradhan.com.saha_sample;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyRecyclerViewAdapter extends RecyclerView
        .Adapter<MyRecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private static MyClickListener myClickListener;


    private Cursor mCurser;

    MyRecyclerViewAdapter(Cursor cursor) {

        this.mCurser = cursor;
    }

    void setOnItemClickListener(MyClickListener myClickListener) {
        MyRecyclerViewAdapter.myClickListener = myClickListener;
    }

    @NonNull
    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_row22, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull DataObjectHolder holder, int position) {

        if (!mCurser.moveToPosition(position)) {
            return;
        }
        holder.label.setText(mCurser.getString(1));
        holder.dateTime.setText(mCurser.getString(3));
        holder.agentPic.setImageResource(R.drawable.agent1);
    }

    public void addItem(Agent dataObj, int index) {
        /*        mDataset.add(index, dataObj);*/
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
/*
        mDataset.remove(index);
*/
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mCurser.getCount();
    }

    public interface MyClickListener {
        void onItemClick(int position, View v);
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView label;
        TextView dateTime;
        ImageView agentPic;

        DataObjectHolder(View itemView) {
            super(itemView);
            label = itemView.findViewById(R.id.textView);
            dateTime = itemView.findViewById(R.id.textView2);
            agentPic = itemView.findViewById(R.id.agent_pic);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
            Toast.makeText(v.getContext(), "More details", Toast.LENGTH_SHORT).show();
        }
    }
}