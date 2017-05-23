package week14;

/**
 * Generic List
 * 
 * @author Scott LaChance
 *
 */
public class List<T>
{
	/**
	 * Default constructor
	 */
	public List()
	{
		this("list");
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            list name
	 */
	public List(String name)
	{
		m_name = name;
		m_firstNode = null;
		m_lastNode = null;
		m_size = 0;
	}

	/**
	 * Insert the data at the front of the list
	 * 
	 * @param insertItem
	 *            Data to insert into the front of the list
	 */
	public T insertAtFront(T insertItem)
	{
		if(isEmpty())
		{
			m_firstNode = m_lastNode = new ListNode<T>(insertItem);
		}
		else
		{
			m_firstNode = new ListNode<T>(insertItem, m_firstNode);
		}
		
		m_size++;
		return m_firstNode.getData();
	}

	/**
	 * Insert the data at the back of the list
	 * 
	 * @param insertItem
	 *            Data to insert into the back of the list
	 */
	public T insertAtBack(T insertItem)
	{
		if(isEmpty())
		{
			m_firstNode = m_lastNode = new ListNode<T>(insertItem);
		}
		else
		{
			m_lastNode = m_lastNode.m_nextNode = new ListNode<T>(insertItem);
		}
		
		m_size++;
		return m_lastNode.getData();
	}

	/**
	 * Remove the first time in the list
	 * @return Data from the first item
	 * @throws EmptyListException if list is empty
	 */
	public T removeFromFront() throws EmptyListException
	{
		if(isEmpty())
		{
			throw new EmptyListException(m_name);
		}
		
		T removeItem = m_firstNode.getData();
		
		if(m_firstNode == m_lastNode)
		{
			// last item, list is now empty
			m_firstNode = m_lastNode = null;
		}
		else
		{
			m_firstNode = m_firstNode.getNext();
		}
		
		m_size--;
		return removeItem;
	}

	/**
	 * Remove the last time in the list
	 * @return Data from the last item
	 * @throws EmptyListException if list is empty
	 */
	public T removeFromBack() throws EmptyListException
	{
		if(isEmpty())
		{
			throw new EmptyListException(m_name);
		}
		
		T removeItem = m_lastNode.getData();
		
		if(m_firstNode == m_lastNode)
		{
			// last item, list is now empty
			m_firstNode = m_lastNode = null;
		}
		else
		{
			m_firstNode = m_firstNode.getNext();
			ListNode<T> currentNode = m_firstNode;
			
			// loop while current isn't the last node
			while(currentNode.getNext() != m_lastNode)
			{
				m_lastNode = currentNode;
				currentNode.m_nextNode = null;
			}
		}
		
		m_size--;
		return removeItem;
	}
	
	public int size()
	{
		return m_size;
	}

	/**
	 * Checks if list is empty
	 * 
	 * @return true if not empty, otherwise false
	 */
	public boolean isEmpty()
	{
		return m_firstNode == null;
	}
	
	public String print()
	{
		StringBuilder builder = new StringBuilder();
		
		if(isEmpty())
		{
			builder.append("Empty " + m_name);
		}
		
		builder.append(String.format("The %s is: ",m_name));
		builder.append("\n");
		
		ListNode<T> currentNode = m_firstNode;
		
		while(currentNode != null)
		{
			builder.append(String.format(" - %s ",currentNode.getData()));
			builder.append("\n");
			currentNode = currentNode.getNext();
		}
		
		return builder.toString();
	}

	// Private data
	private int m_size;
	private ListNode<T> m_firstNode;
	private ListNode<T> m_lastNode;
	private String m_name; // string like "list" used in printing.
}
