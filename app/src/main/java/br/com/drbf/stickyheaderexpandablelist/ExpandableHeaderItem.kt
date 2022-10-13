package br.com.drbf.stickyheaderexpandablelist

import android.view.View
import br.com.drbf.stickyheaderexpandablelist.R
import br.com.drbf.stickyheaderexpandablelist.databinding.ItemListParentBinding
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.viewbinding.BindableItem

/**
 * @author kemosabe_x
 * Created on 5/22/20
 */
class ExpandableHeaderItem(val title: String) : BindableItem<ItemListParentBinding>(),
    ExpandableItem, StickyItem {

    private lateinit var expandableGroup: ExpandableGroup

    public var expnded : Boolean = false;

//    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
//        viewHolder.root.parent_text_title.text = title
//        viewHolder.itemView.setOnClickListener {
//            expandableGroup.onToggleExpanded()
//            changeStuff2(viewHolder)
//        }
//
//    }

    override fun isSticky(): Boolean {
        return true
    }

    override fun getLayout(): Int {
        return R.layout.item_list_parent
    }


    private fun changeStuff(viewBinding: ItemListParentBinding) {

        viewBinding.indicator.apply {
            var expnded = expandableGroup.isExpanded

            setImageResource(

                if (expnded) R.drawable.ic_expanded_indicator
                else R.drawable.ic_collapsed_indicator
            )


        }

    }

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        this.expandableGroup = onToggleListener


    }



    override fun bind(viewBinding: ItemListParentBinding, position: Int) {

        viewBinding.parentTextTitle.text = title
        viewBinding.root.setOnClickListener {
            expandableGroup.onToggleExpanded()
            expandableGroup.notifyChanged()

        }

        changeStuff(viewBinding)
    }

    override fun initializeViewBinding(view: View): ItemListParentBinding =
        ItemListParentBinding.bind(view)


}