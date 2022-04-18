package recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a109590015_hw7_2.R;

import java.util.LinkedList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder>  {

    private final LayoutInflater mInflater;
    private final LinkedList<String> recipeTitle;
    private final LinkedList<String> reciptSubtitle;
    private final Context context;

    public RecipeAdapter(Context context, LinkedList<String> recipeTitle, LinkedList<String> reciptSubtitle){
        mInflater = LayoutInflater.from(context);
        this.recipeTitle = recipeTitle;
        this.reciptSubtitle = reciptSubtitle;
        this.context = context;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.word_list, parent, false);
        return new RecipeViewHolder(mItemView, this, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        String title = recipeTitle.get(position);
        String subtitle = reciptSubtitle.get(position);
        holder.wordItemView.setText(title);
        holder.subwordItemView.setText(subtitle);
        holder.index = position;
    }

    @Override
    public int getItemCount() {
        return recipeTitle.size();
    }
}
