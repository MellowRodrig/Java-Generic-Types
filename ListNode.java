package week14;

/**
 * 
 * @author Brandon Rodriguez
 * 
 *@Date April 15, 2017
 *
 * @param <T>
 */

public class ListNode<T> {
	
	T m_data;
	ListNode<T> m_nextNode;
	
	ListNode(T object)
	{
		this(object, null);
	}

	ListNode(T object, ListNode<T> node)
	{
		// TODO Auto-generated constructor stub
		m_data = object;
		m_nextNode = node;
	}
	
	T getData()
	{
		return m_data;
	}
	
	ListNode <T> getNext()
	{
		return m_nextNode;
	}
}
