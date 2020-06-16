package com.iyang.learntreecode.balanced;

import java.util.List;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-16
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class ChildRenNode {

    public int val;
    public List<ChildRenNode> children;


    public ChildRenNode() {
    }

    public ChildRenNode(int val, List<ChildRenNode> children) {
        this.val = val;
        this.children = children;
    }
}
