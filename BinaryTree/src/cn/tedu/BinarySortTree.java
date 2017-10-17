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
    //TODO 遍历所有数据,判断是否有重复
    public boolean search(int value)
    {

        return false;
    }


    /**
      * @Method insert()
      * @TODO   按一定顺序批量插入数据或插入数据,数据不能重复
      * @return BTSNode
      * @throws Exception
     */
    public BTSNode insert(int val)
    {
        // 存放临时值的临时的节点
        BTSNode pre = new BTSNode();
        pre.setValue(val);
        // 根节点为空
        if (Utils.objectIsEmpty(root))
        {
            //如果根节点为空,把值存到根节点
            root = pre;
            System.out.println(root.getValue() + "根节点插入");
            return root;
        }
        else
        {
            BTSNode q = pre;
            while (true)
            {
                if (Utils.compare(val, root.getValue()))
                {
                    //空的节点才能插入
                    if (Utils.objectIsEmpty(q.getRightNode()))
                    {
                        q.setRightNode(pre);
                        System.out.println(q.getValue() + "插入右子树");
                        break;
                    } else
                    {
                        //如果节点不空 , 继续遍历下一个节点
                        q = q.getRightNode();
                        //System.out.println(q.getValue() + "遍历右节点");
                    }
                } else if (Utils.compare(root.getValue(), val))
                {
                    //空节点
                    if (Utils.objectIsEmpty(q.getLeftNode()))
                    {
                        q.setLeftNode(pre);
                        System.out.println(q.getValue() + "插入左子树");
                        break;
                    } else
                    {
                        q = q.getLeftNode();
                    }
                } else
                {
                    break;
                }
            }
        }
        return pre;
    }
    //访问节点
    public static void visit(BTSNode p)
    {

        System.out.println(p.getValue() + "节点插入");
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
        int[] num =
        {4, 7, 2, 1, 10, 6, 9, 3, 8, 11, 5};
        for (int i = 0; i < num.length; i++)
        {
            BTSNode node = tree.insert(num[i]);
            System.out.println(node.getValue() + "--node");

        }

    }

}
