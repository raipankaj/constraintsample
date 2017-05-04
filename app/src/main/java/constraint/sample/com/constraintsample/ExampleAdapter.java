package constraint.sample.com.constraintsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private String[] mStringArray;
    private OnItemClickListener mOnItemClickListener;

    public ExampleAdapter(String[] stringArray, OnItemClickListener onItemClickListener) {
        mStringArray = stringArray;
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ExampleViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_items, parent, false));
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        holder.textView.setText(mStringArray[position]);
    }

    @Override
    public int getItemCount() {
        return mStringArray.length;
    }

    class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;

        public ExampleViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.tv_type_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnItemClickListener.onClick(getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }

}
