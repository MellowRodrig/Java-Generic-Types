package week14;

public class EmptyListException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7781103699858673354L;
	
	public EmptyListException()
	{
		super();
	}
	
	public EmptyListException(String msg)
	{
		super(msg);
	}
	
	public EmptyListException(String msg, Throwable err)
	{
		super(msg, err);
	}
}
