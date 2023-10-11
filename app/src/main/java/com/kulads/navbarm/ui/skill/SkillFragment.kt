package com.kulads.navbarm.ui.skill

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kulads.navbarm.R
import java.util.Locale

class SkillFragment : Fragment() {

    companion object {
        fun newInstance() = SkillFragment()
    }
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var viewModel: SkillViewModel
    private var mylist = ArrayList<LanguageData>()
    private lateinit var adapter: LanguageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_skill, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SkillViewModel::class.java)

        // TODO: Use the ViewModel
        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        addDataToList()
        adapter = LanguageAdapter(mylist)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }
    private fun filterList(query : String?){

        if (query != null){
            val filterList = ArrayList<LanguageData>()
            for (i in mylist){
                if (i.title.lowercase(Locale.ROOT).contains(query)){
                    filterList.add(i)
                }
            }

            if(filterList.isEmpty()){
                Toast.makeText(this , "No Data found" , Toast.LENGTH_SHORT).show()
            }else{
                adapter.setFilterList(filterList)
            }
        }
    }

    private fun addDataToList() {
        mylist.add(LanguageData("Bootstrap" , R.drawable.bootstrap))
        mylist.add(LanguageData("CSS" , R.drawable.css))
        mylist.add(LanguageData("Figma" , R.drawable.figma))
        mylist.add(LanguageData("HTML" , R.drawable.html))
        mylist.add(LanguageData("Java" , R.drawable.java))
        mylist.add(LanguageData("Javascript" , R.drawable.javascript))
        mylist.add(LanguageData("Kotlin" , R.drawable.kotlin))
        mylist.add(LanguageData("MySQL" , R.drawable.mysql))
        mylist.add(LanguageData("PhotoShop" , R.drawable.photoshop))
        mylist.add(LanguageData("PHP" , R.drawable.php))
    }

}