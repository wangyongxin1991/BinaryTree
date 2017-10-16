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
    //TODO 查找数据
    public void searchkey()
    {

    }


    //TODO 输出的值不对
    public BTSNode insert(int val)
    {
        //存放临时值得临时的节点
        BTSNode pre = new BTSNode();
        pre.setValue(val);
        // 根节点为空
        if (Utils.objectIsEmpty(root))
            //如果根节点为空,把值存到根节点
            root = pre;
        else
        {
            BTSNode q = this.root;
            while (true)
            {
                if (Utils.compare(val, q.getValue()))
                {
                    //节点是空的节点才能插入
                    if (Utils.objectIsEmpty(q.getRightNode()))
                    {
                        q.setRightNode(pre);
                        visit(q);
                        break;
                    } else
                    {
                        //如果节点不空 , 继续遍历下一个节点
                        q = q.getRightNode();
                    }
                } else if (Utils.compare(root.getValue(), val))
                {
                    //空节点
                    if (Utils.objectIsEmpty(q.getLeftNode()))
                    {
                        q.setLeftNode(pre);
                        break;
                    } else
                    {
                        q = q.getLeftNode();
                    }
                } else
                {
                    System.out.println(pre.getValue() + "节点存在!");
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
            tree.insert(num[i]);

        }

    }

}
