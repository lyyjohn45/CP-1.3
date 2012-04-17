//学习到很多,复习以前学过的一个cache方法。
//利用一个tail来表明已经check过的element,然后每一个non-duplicate加在tail的位置,然后tail++

//Note:这个程序在没有duplicate的情况下会crush,应为没有duplicate的话tail是只在end of the string这个时候sign会out of the bound,求fix

public class removeDuplicate {
	
	public char[] removeDup1 (char[] s)
	{
		if(s == null || s.length < 2)
		{
			return s;
		}
		
		//the tail point to the end of already-unique substring, much like a '/0'
		int tail = 1;
		//the main loop, start with index 1 because no need to check just single value 
		for(int i = 1; i < s.length; ++i)
		{
			int j;
			
			for(j = 0; j < tail; ++j)
			{
				if(s[j] == s[i])//break because find such element is duplicated
					break;
			}
			
			if(j == tail)//no duplicate find in already-unique substring, then we append it to the end
			{
				s[tail] = s[i];
				++tail; //move the tail forward :)
			}
		}
		
		s[tail] = 0; // now we are finished cut the string
		return s;
	}
	
	//with a bitmap
	public char[] removeDup2 (char[] s)
	{
		if(s == null || s.length < 2)
		{
			return s;
		}
		
		boolean[] checkList = new boolean[256];
		
		for(int i =0; i < 256; ++i)
		{
			checkList[i] = false;
		}
		
		checkList[s[0]] = true;
		int tail = 1;
		for(int i = 1; i < s.length; ++i)
		{
			int ascii = s[i];
			if(!checkList[ascii])
			{
				checkList[ascii] = true;
				s[tail] = s[i];// it is no duplicate yet, put it here
				++tail;
			}
		}
		
		s[tail] = 0;
		return s;
	}


	public static void main(String[] args) {
		//String s1 = "abcd";
		String s2 = "abcb";
		String s3 = "aaaa";
		String s4 = "abab";
		String s5 = "";
		String s6 = " ";
		
		removeDuplicate test = new removeDuplicate();
		
		//test.removeDup1(s1.toCharArray());
		test.removeDup1(s2.toCharArray());
		test.removeDup1(s3.toCharArray());
		test.removeDup1(s4.toCharArray());
		test.removeDup1(s5.toCharArray());
		test.removeDup1(s6.toCharArray());
		
		//System.out.println(test.removeDup1(s1.toCharArray()));
		System.out.println(test.removeDup2(s2.toCharArray()));
		System.out.println(test.removeDup2(s3.toCharArray()));
		System.out.println(test.removeDup2(s4.toCharArray()));
		System.out.println(test.removeDup2(s5.toCharArray()));
		System.out.println(test.removeDup2(s6.toCharArray()));
	}

}
