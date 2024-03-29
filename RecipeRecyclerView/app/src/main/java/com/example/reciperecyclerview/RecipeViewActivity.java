/**
 * @file RecipeViewActivity
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

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RecipeViewActivity extends AppCompatActivity {

    /**
     * Code to run when activity is created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);

        Intent intent = getIntent();

        if(intent != null){

            String recipeTitle = intent.getStringExtra("name");
            String recipeImageUrl = intent.getStringExtra("image");
            String recipeIngredients = intent.getStringExtra("ingredients");
            String recipeDirections = intent.getStringExtra("directions");

            // Create recipeTitle view and set the text
            TextView recipeTitleView = findViewById(R.id.recipe_title);
            recipeTitleView.setText(recipeTitle);

            // Create image view and set the image
            ImageView imageView = findViewById(R.id.recipe_image);
            DisplayImage(recipeImageUrl, imageView);

            // Create ingredients view and set the text
            TextView ingredientsTextView = findViewById(R.id.ingredients);
            ingredientsTextView.setText(recipeIngredients);

            // Create directions view and set the text
            TextView directionsTextView = findViewById(R.id.directions);
            directionsTextView.setText(recipeDirections);

        }
    }

    /**
     * Method to display the image with Picasso
     * @param recipeImageUrl
     * @param imageView
     */
    private void DisplayImage(String recipeImageUrl, ImageView imageView){

        Picasso.get()
                .load(recipeImageUrl)
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);

    }

}
