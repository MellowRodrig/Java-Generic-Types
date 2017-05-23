package week14;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class Week14JUnitTest
{
	@Test
	public void testIntegerList()
	{
		int[] testList = { 3, -1, 2, 400, -500 };

		List<Integer> intList = new List<Integer>();

		// populate list except for the first item
		for(int index = 1; index < testList.length; index++)
		{
			int expected = testList[index];
			Integer inserted = intList.insertAtBack(expected);
			assertTrue(inserted.equals(expected));
		}

		// insert at the beginning
		int insertInt = testList[0]; // now insert the first item
		Integer inserted = intList.insertAtFront(insertInt);
		assertTrue(inserted.equals(insertInt));

		trace("List contents");
		trace(intList.print());

		// iterate through the list and verify it is correct
		for(int index = 0; index < testList.length; index++)
		{
			int expected = testList[index];
			try
			{
				trace(String.format("Looking for expected: %d, index: %d",
						expected, index));
				Integer actual = intList.removeFromFront();
				trace(String.format("expected: %d, actual: %d", expected,
						actual));
				assertTrue(actual.equals(expected));
			}
			catch(EmptyListException ex)
			{
				ex.printStackTrace();
				fail(ex.getMessage());
			}
		}
	}

	@Test
	public void testStringList()
	{
		String[] testList = { "one", "hello", "goodbye", "something",
				"mathematics" };

		List<String> intList = new List<String>();

		// populate list except for the first item
		for(int index = 1; index < testList.length; index++)
		{
			String expected = testList[index];
			String inserted = intList.insertAtBack(expected);
			assertTrue(inserted.equals(expected));
		}

		// insert at the beginning
		String insertInt = testList[0]; // now insert the first item
		String inserted = intList.insertAtFront(insertInt);
		assertTrue(inserted.equals(insertInt));

		trace("List contents");
		trace(intList.print());

		// iterate through the list and verify it is correct
		for(int index = 0; index < testList.length; index++)
		{
			String expected = testList[index];
			try
			{
				trace(String.format("Looking for expected: %s, index: %s",
						expected, index));
				String actual = intList.removeFromFront();
				trace(String.format("expected: %s, actual: %s", expected,
						actual));
				assertTrue(actual.equals(expected));
			}
			catch(EmptyListException ex)
			{
				ex.printStackTrace();
				fail(ex.getMessage());
			}
		}
	}

	@Test
	public void testUdtList()
	{
		UserDefinedType[] testList = { new UserDefinedType("one"),
				new UserDefinedType("two"), new UserDefinedType("three"),
				new UserDefinedType("four"), new UserDefinedType("five") };

		List<UserDefinedType> udtList = new List<UserDefinedType>();

		// populate list except for the first item
		for(int index = 1; index < testList.length; index++)
		{
			UserDefinedType expected = testList[index];
			UserDefinedType inserted = udtList.insertAtBack(expected);
			assertTrue(inserted.equals(expected));
		}

		// insert at the beginning
		UserDefinedType insertUdt = testList[0]; // now insert the first item
		UserDefinedType inserted = udtList.insertAtFront(insertUdt);
		assertTrue(inserted.equals(insertUdt));

		trace("List contents");
		trace(udtList.print());

		// iterate through the list and verify it is correct
		for(int index = 0; index < testList.length; index++)
		{
			UserDefinedType expected = testList[index];
			try
			{
				trace(String.format("Looking for expected: %s, index: %s",
						expected, index));
				UserDefinedType actual = udtList.removeFromFront();
				trace(String.format("expected: %s, actual: %s", expected,
						actual));
				assertTrue(actual.equals(expected));
			}
			catch(EmptyListException ex)
			{
				ex.printStackTrace();
				fail(ex.getMessage());
			}
		}
	}

	private void trace(String msg)
	{
		System.out.println(msg);
	}
}

class UserDefinedType
{
	public UserDefinedType(String value)
	{
		m_value = value;
	}

	public String getValue()
	{
		return m_value;
	}
	
	@Override
	public String toString()
	{
		return getValue();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		boolean result = false;
		if(obj instanceof UserDefinedType)
		{
			UserDefinedType rhs = (UserDefinedType)obj;
			result = this.getValue().equals(rhs.getValue());
		}
		
		return result;
	}

	private String m_value;
}
