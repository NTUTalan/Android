package recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a109590015_hw7_2.R;
import com.example.a109590015_hw7_2.RecipePage;

public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public final TextView wordItemView;
    public final TextView subwordItemView;
    public final Context context;
    public int index;

    final RecipeAdapter mAdapter;

    public RecipeViewHolder(@NonNull View itemView, RecipeAdapter adapter, Context context) {
        super(itemView);
        itemView.setOnClickListener(this);
        wordItemView = itemView.findViewById(R.id.word);
        subwordItemView = itemView.findViewById(R.id.subword);
        this.mAdapter = adapter;
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        RecipePage.index = index;
        Intent intent = new Intent(context, RecipePage.class);
        context.startActivity(intent);
    }
}
