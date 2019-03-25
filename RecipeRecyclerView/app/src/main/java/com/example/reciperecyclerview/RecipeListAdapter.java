/**
 * @file RecipeListAdapter
 * @author Melanie Roy-Plommer
 * @version 1.0
 *
 * @section DESCRIPTION
 * <  >
 *
 * @section LICENSE
 * Copyright 2018 - 2019
 * Permission to use, copy, modify, and/or distribute this software for
 * any purpose with or without fee is hereby granted, provided that the
 * above copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 *
 * @section Academic Integrity
 * I certify that this work is solely my own and complies with
 * NBCC Academic Integrity Policy (policy 1111)
 */
package com.example.reciperecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {


    /**
     * Constructor for RecipeListAdapter
     * @param context
     * @param recipes
     */
    public RecipeListAdapter(Context context, LinkedList<Recipe> recipes){
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mRecipeList = recipes;
    }

    /**
     * Inner Class For holding the RecipeView
     */
    class RecipeViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        public final TextView recipeTitleView;
        public final TextView recipeDescriptionView;
        public final ImageView recipeImageView;
        public final TextView recipeIngredientsView;
        public final TextView recipeDirectionsView;


        final RecipeListAdapter mAdapter;

        /**
         * Constructor for RecipeViewHolder
         * @param itemView
         * @param adapter
         */
        public RecipeViewHolder(View itemView, RecipeListAdapter adapter) {
            super(itemView);
            recipeTitleView = itemView.findViewById(R.id.recipe_title);
            recipeDescriptionView = itemView.findViewById(R.id.recipe_desc);
            recipeImageView = itemView.findViewById(R.id.recipe_image);
            recipeIngredientsView = itemView.findViewById(R.id.ingredients);
            recipeDirectionsView = itemView.findViewById(R.id.directions);

            this.mAdapter = adapter;
            itemView.setOnClickListener(this);

        }

        /**
         * On click - gets the current recipe and inserts the key value pairs
         * @param v
         */
        @Override
        public void onClick(View v) {
            Recipe currentRecipe = mRecipeList.get(getLayoutPosition());

            Intent intent = new Intent(mContext, RecipeViewActivity.class);
            intent.putExtra("name",currentRecipe.name);
            intent.putExtra("description", currentRecipe.description);
            intent.putExtra("image",currentRecipe.image);
            intent.putExtra("ingredients", currentRecipe.ingredients);
            intent.putExtra("directions", currentRecipe.directions);

            mContext.startActivity(intent);
        }
    }

    private LinkedList<Recipe> mRecipeList;
    private LayoutInflater mInflater;
    private Context mContext;



    /**
     * Inflate the Recipe View
     * Called when RecyclerView needs a new RecyclerView.ViewHolder
     * of the given type to represent an item.
     * @param viewGroup
     * @param i
     * @return
     */
    @NonNull
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mRecipeItemView = mInflater.inflate(R.layout.recipelist_item, viewGroup, false);
        return new RecipeViewHolder(mRecipeItemView, this);
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * @param recipeViewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int i) {
        Recipe currentRecipe = mRecipeList.get(i);
        recipeViewHolder.recipeTitleView.setText(currentRecipe.name);
        recipeViewHolder.recipeDescriptionView.setText(currentRecipe.description);
    }

    /**
     * Get the size of the recipe list
     * Returns the total number of items in the data set held by the adapter.
     * @return
     */
    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }




}
