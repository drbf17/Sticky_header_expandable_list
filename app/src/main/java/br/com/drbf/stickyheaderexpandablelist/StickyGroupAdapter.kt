package br.com.drbf.stickyheaderexpandablelist

import com.jay.widget.StickyHeaders
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class StickyGroupAdapter : GroupAdapter<GroupieViewHolder>(), StickyHeaders {

    override fun isStickyHeader(position: Int): Boolean {
        val item = getItem(position)
        return item is StickyItem && (item as StickyItem).isSticky()
    }

}