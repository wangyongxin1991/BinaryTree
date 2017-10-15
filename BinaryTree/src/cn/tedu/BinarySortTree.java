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

    private BTSNode root = null;

    public void insert(int value)
    {
        BTSNode p = root;
        //存放前一个的节点
        BTSNode pre = null;

        //如果节点不为空,遍历二叉树  TODO 出现死循环
        while (Utils.objectIsNotEmpty(p))
        {
            pre = p;
            if (Utils.compare(value, p.getValue()))
            {
                p.getRightNode();
            } else if (Utils.compare(p.getValue(), value))
            {
                p.getLeftNode();
            } else
            {
                return;
            }

        }

        // 根节点为空
        if (Utils.objectIsEmpty(p))
            //如果根节点为空,把值存到根节点
            root = new BTSNode(value);
        else if (Utils.compare(value, p.getValue()))
            //如果插入的值比根节点大 ,把新节点放到右子树
            pre.setRightNode(new BTSNode(value));
        else
            //如果插入的值比根节点小 , 把新节点放到左子树
            pre.setLeftNode(new BTSNode(value));
    }
    //访问节点
    public static void visit(BinarySortTree p)
    {

        System.out.println(p.toString() + " ");
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
        {4, 7, 2, 1, 10, 6, 9, 3, 8, 11, 2, 0, -2};
        for (int i = 0; i < num.length; i++)
        {
            tree.insert(num[i]);
            System.out.println(num[i]);
        }

    }

}
