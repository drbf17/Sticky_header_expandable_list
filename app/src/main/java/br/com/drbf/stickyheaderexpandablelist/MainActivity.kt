package br.com.drbf.stickyheaderexpandablelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jay.widget.StickyHeadersLinearLayoutManager
import br.com.drbf.stickyheaderexpandablelist.databinding.ActivityMainBinding
import com.xwray.groupie.ExpandableGroup


class MainActivity : AppCompatActivity() {

    private val groupAdapter = StickyGroupAdapter()
    private lateinit var groupLayoutManager: StickyHeadersLinearLayoutManager<StickyGroupAdapter>

    private val childList = listOf(
        "subitem 1",
        "subitem 2",
        "subitem 3",
        "subitem 4",
        "subitem 5",
        "subitem 6"


    )

    private val parentList = listOf(
     "item 1",
     "item 2",
     "item 3",
     "item 4",
     "item 5",
     "item 6",
     "item 7",
     "item 8",
     "item 9",
     "item 10",
     "item 11",
     "item 12",
     "item 13"

    )

    val list = mutableListOf<ExpandableGroup>()
    var filteredList = mutableListOf<String>()
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        groupLayoutManager = StickyHeadersLinearLayoutManager(this)



        binding.xRecyclerView.apply {
            layoutManager = groupLayoutManager
            adapter = groupAdapter
        }

    for (i in parentList) {
            var eg = ExpandableGroup(ExpandableHeaderItem(i)).apply {
                for (j in childList) {
                    add(ChildItem(j))
                }
            }

            list.add(eg)


        }

        groupAdapter.apply {

            addAll(list)
        }
    }
}
