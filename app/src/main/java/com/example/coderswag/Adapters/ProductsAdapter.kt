package com.example.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.Model.Category
import com.example.coderswag.Model.Product
import com.example.coderswag.R

class ProductsAdapter(
    val context: Context, val products: List<Category>,
    val itemClick: (Product)-> Unit) : RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {

    override fun getItemCount(): Int {
        return products.count()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.product_list_item,parent,false)
        return ProductHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
     holder?.bindProduct(products[position], context)
    }

    inner class ProductHolder(itemView: View, itemClick: (Product) -> Unit) : RecyclerView.ViewHolder(itemView){
        val productImage = itemView?.findViewById<ImageView>(R.id.productImage)
        val productName = itemView?.findViewById<TextView>(R.id.productName)
        val productPrice = itemView?.findViewById<TextView>(R.id.productPrice)

        fun bindProduct(product: Product, context : Context) {
            val resourceId = context.resources.getIdentifier(product.image,
                "drawable",context.packageName)
            productImage.setImageResource(resourceId)
            productName?.text = product.title
            productPrice?.text = product.price
            itemView.setOnClickListener { itemClick(product)

            }
        }
    }
}