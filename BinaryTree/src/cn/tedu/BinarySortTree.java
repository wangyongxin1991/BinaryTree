/**
 * 
 */
package cn.tedu;

/**
 * @ClassName BinarySortTree
 * @author  wyx
 * @date 2017年10月15日 下午10:31:46
 * 
 * 二叉排序树又称二叉查找树
 * 1)可以使一颗空的树
 * 2)若左子树不空,则左子树的所有节点小于根节点
 * 3)若右子树不空,则右子树的所有节点大于根节点
 * 4)左右子树也是二叉排序树
 * 
 * 
 * 
 */
public class BinarySortTree
{

    private BTSNode root;
    // 存放临时值的临时的节点
    BTSNode pre = null;

    /**
      * @Method insert()
      * @TODO   按一定顺序批量插入数据或插入数据,数据不能重复  TODO 插入的值不对
      * @return BTSNode
      * @throws Exception
     */
    public BTSNode insert(BTSNode node)
    {

        // 根节点为空
        if (Utils.objectIsEmpty(root))
        {
            //如果根节点为空,把值存到根节点
            root = node;
            //临时节点赋初值
            pre = node;
            //System.out.println(root.getValue() + "根节点插入");
        }
        else
        {
            while (true)
            {
                //新节点比临时节点大  并且 比根节点大
                if (Utils.compare(node.getValue(), root.getValue()))
                {
                    //空的节点才能插入
                    if (Utils.objectIsEmpty(root.getRightNode()))
                    {
                        root.setRightNode(node);
                        //临时节点=新节点
                        pre = node;
                        // System.out.println(pre.getValue() + "插入右子树");
                        break;
                    } else
                    {
                        //如果节点不空 , 继续遍历下一个节点
                        root = root.getRightNode();
                        //System.out.println(q.getValue() + "遍历右节点");
                    }
                } else if ( Utils.compare(root.getValue(), node.getValue()))

                {
                    //空节点
                    if (Utils.objectIsEmpty(root.getLeftNode()))
                    {
                        root.setLeftNode(node);
                        pre = node;
                        //System.out.println(pre.getValue() + "插入左子树");
                        break;
                    } else
                    {
                        root = root.getLeftNode();
                    }
                } else if (root.getValue() == pre.getValue())
                {
                    System.out.println(pre.getValue() + "数据不能重复");
                    return pre;
                } else
                {

                    return root;
                }
            }
        }
        return root;
    }



    /**
      * @Method main()
      * @TODO   
      * @return void
      * @throws Exception
      */
    public static void main(String[] args)
    {
        BinarySortTree tree = new BinarySortTree();
        BTSNode node = null;
        int[] num =
        {4, 2, 7, 1, 10, 6, 9, 3, 8, 11, 5};
        for (int i = 0; i < num.length; i++)
        {
            node = tree.insert(new BTSNode(num[i]));
        }

        preorder(node);

    }
    //访问节点
    public static void visit(BTNode p)
    {
        System.out.println(p.getKey() + " ");
    }

    // 递归实现前序遍历  
    protected static void preorder(BTSNode p)
    {
        if (p != null)
        {
            visit(p);
            preorder(p.getLeftNode());
            preorder(p.getRightNode());
        }
    }
    //访问节点
    public static void visit(BTSNode p)
    {

        System.out.println(p.getValue());
    }
}
