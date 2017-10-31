/**
 * 
 */
package cn.tedu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

/**
 * @ClassName BinarySortTree
 * @author  wyx
 * @date 2017��10��15�� ����10:31:46
 * 
 * �����������ֳƶ��������
 * 1)��һ��˳�������������ݻ��������,���ݲ����ظ�  
 * 2)ɾ��ĳ���ڵ�
 * 3)�������,��Сֵ
 * 4)����ĳ���ڵ�
 * 5)���������������������׽ڵ�
 * 6)�������  ,�������
 * 7)�������ڵ�ľ���
 * 8)��������Ȩֵ�����СҶ�ӽ��֮��ľ���
 * 9)��������ĳ���ڵ㵽���ڵ��·��
 * 10)���鼯
 * 11)tarjan�㷨  LCA �����������    Tarjan(����)�㷨�Ļ���˼·�����㷨ʵ��
 */
public class BinarySortTree
{
    private static BSTNode root;
    static Vector<Vector<Integer>> allpath = new Vector<Vector<Integer>>();

    /**
      * @Method nodePath()
      * @Descirbe   ����ջʵ�ֶ�������ĳ���ڵ㵽���ڵ��·��
      * 1��ѹ����ڵ㣬�ٴ��������в��ң��ݹ���еģ������δ�ҵ����ٴ��������в��ң����Ҳδ�ҵ����򵯳����ڵ㣬�ٱ���ջ����һ���ڵ㡣
      * 2������ҵ�����ջ�д�ŵĽڵ����·���������Ľڵ㡣
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

        //�˴�ע��ݹ�push
        BSTNode push = stack.push(root);
        if (push != null)
            System.out.println(push.getValue());

        boolean find = nodePath(root.getLeftNode(), node);

        if (!find)
            find = nodePath(root.getRightNode(), node);
        if (!find)
            stack.pop();
        return find;
    }

    //��ӡ·��
    static void printPath(Vector<Integer> path)
    {
        for (Integer integer : path)
        {
            System.out.println(integer);

        }
    }

    static Vector<Integer> path = new Vector<>();
    /**
      * @Method findAllPath()
      * @Descirbe ����������Ȼ�������Ѱ��ĳ���ڵ��ӡ·��,�����浽Vector��,Ҳ���Ա��浽��������   
      * @return void
      * @throws Exception
     */
    public static void findAllPath(BSTNode tree, int nToFind)
    {
        if (tree == null)
            return;

        path.add(tree.getValue());

        if (tree.getLeftNode() != null && tree.getLeftNode().getValue() == nToFind
                || tree.getRightNode() != null && tree.getRightNode().getValue() == nToFind)
        {
            printPath(path);
            allpath.add(path);
            return;
        }
        if (tree.getLeftNode() != null)
            findAllPath(tree.getLeftNode(), nToFind);
        if (tree.getRightNode() != null)
            findAllPath(tree.getRightNode(), nToFind);

        //path.removeAllElements();;
        return;
    }

    /**
      * @Method deepSearch()
      * Ӣ����дΪDFS��Depth First Search
      * @Descirbe  �����������
      *          A
      *         / \ 
      *        B   C
      *       / \ / \
      *      D   EF  G
      * ���Ƚ�A�ڵ�ѹ����У�stack��A��;
      * ��A�ڵ㵯����ͬʱ��A���ӽڵ�C��Bѹ����У���ʱB�ڶѵĶ�����stack(B,C)��
      * ��B�ڵ㵯����ͬʱ��B���ӽڵ�E��Dѹ����У���ʱD�ڶѵĶ�����stack��D,E,C����
      * ��D�ڵ㵯����û���ӽڵ�ѹ��,��ʱE�ڶѵĶ�����stack��E��C����
      * ��E�ڵ㵯����ͬʱ��E���ӽڵ�Iѹ�룬stack��I,C����
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
      * @Descirbe �����������  Ӣ����дΪBFS��Breadth FirstSearch
      *          A
      *         / \ 
      *        B   C
      *       / \ / \
      *      D   EF  G
      * ������Ⱦ��ǰ���α�����, ��������ʵ�ֹ�����ȱ��� ,�����Ĺ������˳��:ABCDEFG
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


    static LinkedList<Integer> list = new LinkedList<>();
    /**
      * @Method BSearchPath()
      * @Descirbe  ��ѯĳ��ֵ,·�����浽List������
      * @return List<Integer>
      * @throws Exception
     */
    public static List<Integer> BSearchPath(BSTNode tree, int nToFind)
    {
        if (tree == null)
            return null;

        list.add(tree.getValue());

        if (tree.getLeftNode() != null && tree.getLeftNode().getValue() == nToFind)
        {
            return list;
        }
        if (tree.getLeftNode() != null)
            BSearchPath(tree.getLeftNode(), nToFind);
        if (tree.getRightNode() != null)
            BSearchPath(tree.getRightNode(), nToFind);
        if (tree.getLeftNode() == null && tree.getRightNode() == null)
        {
            list.remove(tree);
        }
        return list;
    }

    /**
      * @Method insert()
      * @TODO   ��һ��˳�������������ݻ��������,���ݲ����ظ�  
      * @return BTSNode
      * @throws Exception
     */
    public static BSTNode insert(BSTNode node)
       {
        BSTNode nodeNow = root;
        // ���ڵ�Ϊ��
        if (Utils.objectIsEmpty(root))
        {
            root = node;
            return root;
        }
       
        while (Utils.objectIsNotEmpty(nodeNow))
            {
                //�½ڵ����ʱ�ڵ��  ���� �ȸ��ڵ��
            if (Utils.compare(node.getValue(), nodeNow.getValue()))
                {
                    //�յĽڵ���ܲ���
                if (Utils.objectIsEmpty(nodeNow.getRightNode()))
                    {
                    nodeNow.setRightNode(node);
                        // System.out.println(pre.getValue() + "����������");
                        break;
                    } else
                    {
                        //����ڵ㲻�� , ����������һ���ڵ�
                    nodeNow = nodeNow.getRightNode();
                        //System.out.println(q.getValue() + "�����ҽڵ�");
                    }
            } else if (Utils.compare(nodeNow.getValue(), node.getValue()))
                {
                    //�սڵ�
                if (Utils.objectIsEmpty(nodeNow.getLeftNode()))
                    {
                    nodeNow.setLeftNode(node);
                        //System.out.println(pre.getValue() + "����������");
                        break;
                    } else
                    {
                    nodeNow = nodeNow.getLeftNode();
                    }
            } else if (node.getValue() == nodeNow.getValue())
              {
                System.out.println(nodeNow.getValue() + "�����ظ�");
                break;
            }
        }
        return root;
    }


    /**
      * @Method searchParent()
      * @Descirbe  �ݹ���������ڵ��������ڵ�   (����д��)
      *    1.�������ֵ��һ��ֵ����root����root
      *    2.����ֵ��������������������,
      *    3.һ��ֵ��������,һ��ֵ��������,����ڵ�������������ڵ�
      *    4.�������������û�з���root
      * @return BSTNode
      * @throws Exception
     */
    public static BSTNode searchParent(BSTNode tree, int node1, int node2)
    {
        if (Utils.objectIsEmpty(tree) || tree.getValue() == node1 || tree.getValue() == node2)
            return tree;
        //�ݹ��ʱ��Ҫע��ݹ���ҵĽڵ���������
        BSTNode leftNode = searchParent(tree.getLeftNode(), node1, node2);

        BSTNode rightNode = searchParent(tree.getRightNode(), node1, node2);
        
        return leftNode == null && rightNode == null ? root : leftNode == null ? rightNode : leftNode;
    }

    /**
      * @Method searchMax()
      * @Describe    �������ֵ
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
      * @Descirbe ������Сֵ   
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
      * @Describe ����ĳ��ֵ   
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
      * @Method lowestCommonAncestor()
      * @Descirbe    ��һ�ֳ�����Ч�����ݽṹ����¼�¶������еĽṹ��ϵ��(�ǵݹ��������������ڵ�)
      * �������Ҹ��ڵ㣬����Ҫ���ӽڵ������Ҹ��ڵ㣬���������õ�����HashMap���������ι�ϵ�Ĵ洢��
      * �������������г�һ��Ҫ��ڵ�����и��ڵ㣬Ȼ��Ƚ���һ��Ҫ��ڵ�ĸ��ڵ��ڲ�����������У�
      * ��һ�����ֵĽڵ㣬��������Ҫ������Ƚڵ�
      * @return BSTNode
      * @throws Exception
     */
    public BSTNode lowestCommonAncestor(BSTNode root, BSTNode p, BSTNode q)
    {
        Map<BSTNode, BSTNode> parent = new HashMap<>();//�洢��ϵ
        Queue<BSTNode> queue = new LinkedList<>();//��������
        parent.put(root, null);
        queue.add(root);
        while (!parent.containsKey(p) || !parent.containsKey(q))
        {
            BSTNode node = queue.poll();
            if (node != null)
            {
                parent.put(node.getLeftNode(), node);
                parent.put(node.getRightNode(), node);
                queue.add(node.getLeftNode());
                queue.add(node.getRightNode());
            }
        }
        Set<BSTNode> set = new HashSet<>();//p�ڵ���������Ƚڵ�
        while (p != null)
        {
            set.add(p);
            p = parent.get(p);
        }
        while (!set.contains(q))
        {//��һ�����ֵĽڵ㣬����return
            q = parent.get(q);
        }
        return q;
    }

    /**
      * @Method deleteNode()
      * @TODO  ɾ��һ���ڵ�  
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
            //�Ƚϵ�ǰ�ڵ�,���С�ڵ�ǰ�ڵ�ͱ���������
            if (Utils.compare(temp.getValue(), newNode.getValue()))
            {
                isLeftNode = true;
                parent = temp;
                temp = temp.getLeftNode();
                //�Ƚϵ�ǰ�ڵ�,������ڵ�ǰ�ڵ�ͱ���������
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
                //�жϵ�ǰ�ڵ��Ƿ���Ҷ�ӽڵ�
                if (Utils.objectIsEmpty(temp.getLeftNode()) && Utils.objectIsEmpty(temp.getRightNode()))
                {
                    if (isLeftNode == true)
                        parent.setLeftNode(null);
                    if (isLeftNode == false)
                        parent.setRightNode(null);
                    break;
                    //�����ǰ�ڵ㲻��Ҷ�ӽڵ��������������� ,������ǰ�ڵ�������� ,������������ҽڵ�,���ҽڵ����ɾ����λ��. û���ҽڵ�,�õ�ǰ�ڵ���������ĸ��ڵ����ɾ���Ľڵ�
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
                    // û����ڵ�,�õ�ǰ�ڵ���������ĸ��ڵ����ɾ���Ľڵ�
                } else if (Utils.objectIsEmpty(temp.getLeftNode()) && Utils.objectIsNotEmpty(temp.getRightNode()))
                {
                    parent.setLeftNode(temp.getRightNode());
                    break;
                    // û���ҽڵ�,�õ�ǰ�ڵ���������ĸ��ڵ����ɾ���Ľڵ�
                } else if (Utils.objectIsNotEmpty(temp.getLeftNode()) && Utils.objectIsEmpty(temp.getRightNode()))
                {
                    parent.setRightNode(temp.getLeftNode());
                    break;
                }
            }
        }
        return root;
    }

    // �ݹ�ʵ���������  
    protected static void preorder(BSTNode p)
    {
        if (p != null)
        {
            preorder(p.getLeftNode());
            visit(p);
            preorder(p.getRightNode());
        }
    }

    //���ʽڵ�
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
        BinarySortTree tree = new BinarySortTree();
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
        //        System.out.println("����������:");
        //        preorder(node);
        //------------------------------------------------------
        //        ɾ���������鿴
        //        BSTNode deleteNode = deleteNode(new BSTNode(7));
        //        preorder(deleteNode);
        //-----------------------------------------------------
        //        searchParent(root, 4);
        //------------------------------------------------------
        // deepSearch();
        //------------------------------------------------------
        // BreadthFristSearch();
        //-------------------------------------------------
        // nodePath(root, new BSTNode(10));
        //------------------------------------------------
        //        int[] arr = nodeParentArr(root, new BSTNode(3));
        //        for (int i : arr)
        //        {
        //            System.out.println(i);
        //        }
        //---------------------------------------------
        //findAllPath(root, 8);
        //------------------------------
        //        List<Integer> list2 = BSearchPath(root, 8);
        //        for (Integer list : list2)
        //        {
        //            System.out.println(list);
        //        }
        //----------------------------------------
        BSTNode parent = searchParent(root, 8, 9);
        System.out.println(parent.getValue());
    }

}
