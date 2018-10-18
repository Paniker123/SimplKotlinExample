package com.example.vitalii.lab2.searchImage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vitalii.lab2.MainActivity
import com.example.vitalii.lab2.R
import com.example.vitalii.lab2.model.Image
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment: Fragment(),SearchView {

    private lateinit var mPresenter:SearchPresenter
    private lateinit var mImageAdapter:ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter=SearchPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initControllers()
        initRecyclerView()
        mPresenter.loadData(context!!)
    }
    private fun initControllers(){
        searchBtn.setOnClickListener{mPresenter.searchImage(searchingEditText.text.toString())}
    }
    private fun initRecyclerView(){
        mImageAdapter=ImageAdapter()
      listOfImagesToLike.apply {
          layoutManager=  LinearLayoutManager(context)
          adapter=mImageAdapter
      }
    }


    override fun goToItemPosition(position: Int) {
        listOfImagesToLike.scrollToPosition(position)
    }

    override fun showToastMessage(message: String) {
        (activity as MainActivity).showToastMessage(message)
    }

    override fun setDataToAdapter(listOfImages: List<Image>) {
        mImageAdapter.mImageList=listOfImages
        mImageAdapter.notifyDataSetChanged()
    }
}