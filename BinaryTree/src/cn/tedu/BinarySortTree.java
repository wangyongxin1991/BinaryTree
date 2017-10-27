/**
 * 
 */
package cn.tedu;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName BinarySortTree
 * @author  wyx
 * @date 2017年10月15日 下午10:31:46
 * 
 * 二叉排序树又称二叉查找树
 * 1)按一定顺序批量插入数据或插入数据,数据不能重复  
 * 2)删除某个节点
 * 3)查找最大,最小值
 * 4)查找某个节点
 * 5)二叉查找树的最近公共父亲节点
 * 6)深度优先  ,广度优先
 * 7)求两个节点的距离
 * 8)二叉树求权值最大最小叶子结点之间的距离
 * 9)二叉树中某个节点到根节点的路径
 */
public class BinarySortTree<T extends Comparable<? super T>>
{
    private static BSTNode root;

    /**
      * @Method nodePath()
      * @Descirbe   二叉树中某个节点到根节点的路径
      * 1）压入根节点，再从左子树中查找（递归进行的），如果未找到，再从右子树中查找，如果也未找到，则弹出根节点，再遍历栈中上一个节点。
      * 2）如果找到，则栈中存放的节点就是路径所经过的节点。
      * @return void
      * @throws Exception
     */
    public static boolean nodePath(BSTNode root, BSTNode node)
    {
        Stack<BSTNode> stack = new Stack<>();
        if (Utils.objectIsEmpty(root)||Utils.objectIsEmpty(node))
            return false;
        if (root.getValue() == node.getValue())
        {
            //System.out.println(root.getValue());
            return true;
        }

        //此处注意递归push
        BSTNode push = stack.push(root);
        if (push != null)
            System.out.println(push.getValue());

        boolean find = nodePath(root.getLeftNode(), node);
        //        if (find)
        //            System.out.println(root.getValue());
        if (!find)
            find = nodePath(root.getRightNode(), node);
        if (!find)
            stack.pop();
        return find;
    }

    /**
      * @Method deepSearch()
      * 英文缩写为DFS即Depth First Search
      * @Descirbe  深度优先搜索
      *          A
      *         / \ 
      *        B   C
      *       / \ / \
      *      D   EF  G
      * 首先将A节点压入堆中，stack（A）;
      * 将A节点弹出，同时将A的子节点C，B压入堆中，此时B在堆的顶部，stack(B,C)；
      * 将B节点弹出，同时将B的子节点E，D压入堆中，此时D在堆的顶部，stack（D,E,C）；
      * 将D节点弹出，没有子节点压入,此时E在堆的顶部，stack（E，C）；
      * 将E节点弹出，同时将E的子节点I压入，stack（I,C）；
      * @return BSTNode
      * @throws Exception
     */
    public static BSTNode deepSearch()
    {
        Stack<BSTNode> stack = new Stack<>();
        if (Utils.objectIsNotEmpty(root))
            stack.push(root);

        while (Utils.objectIsNotEmpty(stack))
        {
            BSTNode topNode = stack.pop();
            System.out.println(topNode.getValue());
            if (Utils.objectIsNotEmpty(topNode.getRightNode()))
            {
                stack.push(topNode.getRightNode());
            }
            if (Utils.objectIsNotEmpty(topNode.getLeftNode()))
            {
                stack.push(topNode.getLeftNode());
            }
        }
        return null;
    }

    /**
      * @Method BreadthFristSearch()
      * @Descirbe 广度优先搜索  英文缩写为BFS即Breadth FirstSearch
      *          A
      *         / \ 
      *        B   C
      *       / \ / \
      *      D   EF  G
      * 广度优先就是按层次遍历树, 借助队列实现广度优先遍历 ,此树的广度优先顺序:ABCDEFG
      * @throws Exception
     */
    public static void BreadthFristSearch()
    {
        LinkedList<BSTNode> list = new LinkedList<>();
        BSTNode topNode = null;

        if (Utils.objectIsNotEmpty(root))
            list.offer(root);

        while (Utils.objectIsNotEmpty(list))
        {
            topNode = list.poll();
            if (Utils.objectIsEmpty(topNode))
                return;
            System.out.println(topNode.getValue());
            if (Utils.objectIsNotEmpty(topNode.getLeftNode()))
                list.offer(topNode.getLeftNode());
            if (Utils.objectIsNotEmpty(topNode.getRightNode()))
                list.offer(topNode.getRightNode());
        }
        return;
    }

    /**
      * @Method insert()
      * @TODO   按一定顺序批量插入数据或插入数据,数据不能重复  
      * @return BTSNode
      * @throws Exception
     */
    public static BSTNode insert(BSTNode node)
       {
        BSTNode nodeNow = root;
        // 根节点为空
        if (Utils.objectIsEmpty(root))
        {
            root = node;
            return root;
        }
       
        while (Utils.objectIsNotEmpty(nodeNow))
            {
                //新节点比临时节点大  并且 比根节点大
            if (Utils.compare(node.getValue(), nodeNow.getValue()))
                {
                    //空的节点才能插入
                if (Utils.objectIsEmpty(nodeNow.getRightNode()))
                    {
                    nodeNow.setRightNode(node);
                        // System.out.println(pre.getValue() + "插入右子树");
                        break;
                    } else
                    {
                        //如果节点不空 , 继续遍历下一个节点
                    nodeNow = nodeNow.getRightNode();
                        //System.out.println(q.getValue() + "遍历右节点");
                    }
            } else if (Utils.compare(nodeNow.getValue(), node.getValue()))
                {
                    //空节点
                if (Utils.objectIsEmpty(nodeNow.getLeftNode()))
                    {
                    nodeNow.setLeftNode(node);
                        //System.out.println(pre.getValue() + "插入左子树");
                        break;
                    } else
                    {
                    nodeNow = nodeNow.getLeftNode();
                    }
            } else if (node.getValue() == nodeNow.getValue())
              {
                System.out.println(nodeNow.getValue() + "数据重复");
                break;
            }
        }
        return root;
    }


    /**
      * @Method searchParent()
      * @Descirbe  递归查找两个节点的最近父节点   
      *    1.如果两个值有一个值等于root返回root
      *    2.两个值都在左子树或都在右子树,
      *    3.一个值在左子树,一个值在右子树,则根节点是最近公共父节点
      *    4.如果左右子树都没有返回root
      * @return BSTNode
      * @throws Exception
     */
    public static BSTNode searchParent(BSTNode tree, int node1, int node2)
    {
        if (Utils.objectIsEmpty(tree))
        {
            return null;
        }

        if (tree.getValue() == node1 || tree.getValue() == node2)
        {
            return tree;
        }

        BSTNode leftNode = searchParent(tree, node1, node2);
        BSTNode rightNode = searchParent(tree, node1, node2);

        if(Utils.objectIsEmpty(leftNode) || Utils.objectIsEmpty(rightNode))
            return null;
        //一个节点在左子树,一个在右子树
        if (Utils.compare(root.getValue(), leftNode.getValue())
                && Utils.compare(rightNode.getValue(), root.getValue()))
        {
            return root;
            //都在左子树
        }else if(Utils.compare(root.getValue(), leftNode.getValue())
                &&Utils.compare(root.getValue(), rightNode.getValue())){
            
            //都在右子树
        } else if (Utils.compare(leftNode.getValue(), root.getValue())
                && Utils.compare(rightNode.getValue(), root.getValue()))
        {
            
        }

        return tree;
    }

    /**
      * @Method searchMax()
      * @Describe    查找最大值
      * @return BSTNode
      * @throws Exception
     */
    public BSTNode searchMax(BSTNode newNode)
    {
        BSTNode rightNode = null;
        if (root == null)
        {
            root = new BSTNode();
            return root;
        }
        if (newNode == null)
            throw new NullPointerException();
        while (Utils.objectIsNotEmpty(root))
        {
            rightNode = root.getRightNode();
        }
        return rightNode;
    }

    /**
      * @Method searchMin()
      * @Descirbe 查找最小值   
      * @return BSTNode
      * @throws Exception
     */
    public BSTNode searchMin(BSTNode newNode)
    {
        if (Utils.objectIsEmpty(root))
        {
            root = new BSTNode();
            return root;
        }
        if (Utils.objectIsEmpty(newNode))
            throw new NullPointerException();
        BSTNode leftNode = null;
        while (Utils.objectIsNotEmpty(root))
        {
            leftNode = root.getLeftNode();
        }
        return leftNode;
    }

    /**
      * @Method searchOne()
      * @Describe 查找某个值   
      * @return BSTNode
      * @throws Exception
     */
    public static BSTNode searchOne(BSTNode newNode)
    {
        if (Utils.objectIsEmpty(root))
        {
            root = new BSTNode();
            return root;
        }
        if (Utils.objectIsEmpty(newNode))
            throw new NullPointerException();

        BSTNode tempNode = new BSTNode();
        tempNode = root;
        while (Utils.objectIsNotEmpty(tempNode))
        {
            if(Utils.compare(tempNode.getValue(), newNode.getValue()))
                tempNode = tempNode.getLeftNode();
            if(Utils.compare(newNode.getValue(), tempNode.getValue()))
                tempNode = tempNode.getRightNode();
            if (newNode.getValue() == tempNode.getValue())
                break;
        }
        return tempNode;
    }

    /**
      * @Method deleteNode()
      * @TODO  删除一个节点  
      * @return void
      * @throws Exception
     */
    public static BSTNode deleteNode(BSTNode newNode)
       {
        BSTNode temp = new BSTNode();
        boolean isLeftNode = false;
         if (Utils.objectIsEmpty(root))
        {
            return root;
        }
        temp = root;
        BSTNode parent = new BSTNode();
        while (true)
        {
            //比较当前节点,如果小于当前节点就遍历左子树
            if (Utils.compare(temp.getValue(), newNode.getValue()))
            {
                isLeftNode = true;
                parent = temp;
                temp = temp.getLeftNode();
                //比较当前节点,如果大于当前节点就遍历右子树
            } else if (Utils.compare(newNode.getValue(), temp.getValue()))
            {
                isLeftNode = false;
                parent = temp;
                temp = temp.getRightNode();
            } else if (newNode.getValue() == temp.getValue())
            {
                BSTNode LNode = null;
                if(Utils.objectIsNotEmpty(temp.getRightNode()))
                    LNode = temp.getRightNode();
                //判断当前节点是否是叶子节点
                if (Utils.objectIsEmpty(temp.getLeftNode()) && Utils.objectIsEmpty(temp.getRightNode()))
                {
                    if (isLeftNode == true)
                        parent.setLeftNode(null);
                    if (isLeftNode == false)
                        parent.setRightNode(null);
                    break;
                    //如果当前节点不是叶子节点且左右子树都有 ,遍历当前节点的左子树 ,如果左子树有右节点,让右节点代替删除的位置. 没有右节点,让当前节点的左子树的根节点代替删除的节点
                } else if (Utils.objectIsNotEmpty(temp.getLeftNode()) && Utils.objectIsNotEmpty(temp.getRightNode()))
                {
                    BSTNode LParent = new BSTNode();
                    BSTNode RightTemp = null;
                    RightTemp = temp.getRightNode();
                    BSTNode LeftTemp = temp.getLeftNode();
                    while (Utils.objectIsNotEmpty(LeftTemp))
                    {
                        LParent = LeftTemp;
                        LeftTemp = LeftTemp.getRightNode();
                    }
                    parent.setLeftNode(LParent);
                    LParent.setRightNode(RightTemp);
                    break;
                    // 没有左节点,让当前节点的左子树的根节点代替删除的节点
                } else if (Utils.objectIsEmpty(temp.getLeftNode()) && Utils.objectIsNotEmpty(temp.getRightNode()))
                {
                    parent.setLeftNode(temp.getRightNode());
                    break;
                    // 没有右节点,让当前节点的左子树的根节点代替删除的节点
                } else if (Utils.objectIsNotEmpty(temp.getLeftNode()) && Utils.objectIsEmpty(temp.getRightNode()))
                {
                    parent.setRightNode(temp.getLeftNode());
                    break;
                }
            }
        }
        return root;
    }

    // 递归实现中序遍历  
    protected static void preorder(BSTNode p)
    {
        if (p != null)
        {
            preorder(p.getLeftNode());
            visit(p);
            preorder(p.getRightNode());
        }
    }

    //访问节点
    public static void visit(BSTNode p)
    {
        System.out.println(p.getValue());
    }

    /**
     * @Method main()
     * @TODO   
     * @return void
     * @throws Exception
     */
    public static void main(String[] args)
    {
        BinarySortTree<String> tree = new BinarySortTree<String>();
        BSTNode node = null;
        int[] num =
        {6, 11, 2, 7, 1, 10, 5, 9, 3, 8, 4};
        for (int i = 0; i < num.length; i++)
        {
            //tree.insert(String.valueOf(num[i]));
            node = insert(new BSTNode(num[i]));
        }

        //        BSTNode one = searchOne(new BSTNode(17));
        //        System.out.println("find Result: " + one.getValue());
        //----------------------------------------------------
        //        System.out.println("中序遍历结果:");
        //        preorder(node);
        //------------------------------------------------------
        //        删除结果中序查看
        //        BSTNode deleteNode = deleteNode(new BSTNode(7));
        //        preorder(deleteNode);
        //-----------------------------------------------------
        //        searchParent(root, 4);
        //------------------------------------------------------
        // deepSearch();
        //------------------------------------------------------
        // BreadthFristSearch();
        //-------------------------------------------------
        nodePath(root, new BSTNode(10));
    }

}
