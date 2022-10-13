package br.com.drbf.stickyheaderexpandablelist

import android.view.View
import br.com.drbf.stickyheaderexpandablelist.R
import br.com.drbf.stickyheaderexpandablelist.databinding.ItemListChildBinding
import com.xwray.groupie.viewbinding.BindableItem


open class ChildItem(val title: String) : BindableItem<ItemListChildBinding>() {

    //    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
//        viewHolder.root.child_textTitle.text = title
//
//    }
//    override fun getLayout(): Int {
//        return R.layout.item_list_child
//    }
    override fun bind(viewBinding: ItemListChildBinding, position: Int) {

        viewBinding.childTextTitle.text = title
    }

    override fun getLayout(): Int = R.layout.item_list_child

    override fun initializeViewBinding(view: View): ItemListChildBinding =
        ItemListChildBinding.bind(view)

}
