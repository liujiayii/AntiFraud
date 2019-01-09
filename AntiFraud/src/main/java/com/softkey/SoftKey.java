package com.softkey;


public class SoftKey {
	
	private String myhex(byte indata)
	{
		String outstring;
		outstring=String.format("%X",indata);
		if(outstring.length()<2)outstring="0"+outstring;
		return outstring;
	}
	
	//若某字节为负数则需将其转成无符号正数
    private  long conver(byte temp){
        long tempInt = (int)temp;
        if(tempInt < 0){
            tempInt += 256;
        }
        return tempInt;
    }

	 //以下用于将16进制字符串转化为无符号长整型
    private int HexToInt(String s)
    {
        String [] hexch = { "0", "1", "2", "3", "4", "5", "6", "7",
						       "8", "9", "A", "B", "C", "D", "E", "F"};
        int i, j;
        int r, n, k;
        String ch;

        k = 1; r = 0;
        for (i = s.length(); i > 0; i--)
        {
            ch = s.substring(i - 1,  i-1+1);
            n = 0;
            for (j = 0; j < 16; j++)
            {
                if (ch.compareToIgnoreCase(hexch[j]) ==0 )
                {
                    n = j;
                }
            }
            r += (n * k);
            k *= 16;
        }
        return r;
    }
	
    
    public String  StrEnc(String InString , String Key)//使用增强算法，加密字符串
    {

        byte [] b,outb;
        byte []temp_b=InString.getBytes();
        byte [] temp=new byte[8],outtemp=new byte[8];
        int n,i,nlen,outlen;
        String outstring;

        nlen = temp_b.length;
        nlen=nlen+1;
        if( nlen < 8 )
            outlen = 8;
        else
            outlen = nlen;
        b=new byte[outlen];
        outb=new byte[outlen];

        for(n=0;n<nlen-1;n++)
        {
        	b[n]=temp_b[n];
        }

        outb=b.clone();

        for( n = 0; n<=outlen - 8 ;n=n+ 8)
        {
            for (i = 0; i < 8; i++) temp[i] = b[i + n];
            EnCode(temp, outtemp, Key);
            for( i = 0 ;i<8;i++) outb[i + n] = outtemp[i];
        }

        outstring = "";
        for (n = 0 ;n<= outlen - 1;n++)
        {
            outstring = outstring +myhex(outb[n]) ;
        }
        return outstring;
    }
    
    public String  StrDec(String InString , String Key)//使用增强算法，解密字符串
    {

        byte [] b,outb;
        byte [] temp=new byte[8],outtemp=new byte[8];
        int n,i,nlen,outlen;
        String outstring,temp_string;

        
        nlen = InString.length();
        if( nlen < 16 ) outlen = 16;
        outlen = nlen / 2;
        b=new byte[outlen];
        outb=new byte[outlen];

        i = 0;
        for (n = 1 ;n<= nlen ;n=n+2)
        {
            temp_string = InString.substring(n-1, n-1+2);
            b[i] = (byte)HexToInt(temp_string);
            i = i + 1;
        }

        outb=b.clone();

        for( n = 0; n<=outlen - 8 ;n=n+ 8)
        {
            for (i = 0; i < 8; i++) temp[i] = b[i + n];
            DeCode(temp, outtemp, Key);
            for( i = 0 ;i<8;i++) outb[i + n] = outtemp[i];
        }

        outstring=new String(outb);
        outstring=outstring.trim();
        return outstring;
    }
    
	public void EnCode(byte[] inb, byte[] outb,  String Key )
    {

		long cnDelta,y,z,a,b,c,d,temp_2;
		long [] buf=new long[16];
       int n,i,nlen;
       long sum;
       long temp,temp_1;
       long mask=4294967295L;

       //UInt32 temp, temp_1;
       String temp_String ;
      

       cnDelta = 2654435769L;
       sum = 0;

       nlen = Key.length();
       i = 0;
       for( n = 1 ;n<= nlen ;n=n+2)
       {
           temp_String =Key.substring(n-1, n-1+2); 
           buf[i] =HexToInt(temp_String);
           i = i + 1;
       }
       a = 0 ; b = 0 ; c = 0 ; d = 0;
       for(n = 0;n<=3;n++)
       {
           a = (buf[n] << (n * 8)) | a;
           b = (buf[n + 4] << (n * 8)) | b;
           c = (buf[n + 4 + 4] << (n * 8)) | c;
           d = (buf[n + 4 + 4 + 4] << (n * 8)) | d;
       }


       y = 0;
       z = 0;
       for(n = 0;n<=3;n++)
       {
           temp_2 = conver(inb[n]);
           y = (temp_2 << (n * 8)) | y;
           temp_2 = conver(inb[n + 4]);
           z = (temp_2 << (n * 8)) | z;
       }


       n = 32;

       while (n > 0)
       {
           sum = (cnDelta + sum)& mask;

           temp = (z << 4) & mask;
           temp = (temp + a) & mask;
           temp_1 = (z + sum) & mask;
           temp = (temp ^ temp_1) & mask;
           temp_1 = (z >> 5) & mask;
           temp_1 = (temp_1 + b) & mask;
           temp = (temp ^ temp_1) & mask;
           temp = (temp + y) & mask;
           y = temp & mask;
           /*y += ((z << 4) + a) ^ (z + sum) ^ ((z >> 5) + b); */

           temp = (y << 4) & mask;
           temp = (temp + c) & mask;
           temp_1 = (y + sum) & mask;
           temp = (temp ^ temp_1) & mask;
           temp_1 = (y >> 5) & mask;
           temp_1 = (temp_1 + d) & mask;
           temp = (temp ^ temp_1) & mask;
           temp = (z + temp) & mask;
           z = temp & mask;
           /* z += ((y << 4) + c) ^ (y + sum) ^ ((y >> 5) + d); */
           n = n - 1;

       }
       for(n = 0;n<=3;n++)
       {
           outb[n] = (byte)((y >>> (n * 8)) & 255);
           outb[n + 4] =(byte)((z >>> (n * 8)) & 255);
       }
    }
	
	public void DeCode(byte[] inb, byte[] outb,  String Key )
    {

		long cnDelta,y,z,a,b,c,d,temp_2;
		long [] buf=new long[16];
       int n,i,nlen;
       long sum;
       long temp,temp_1;
 
       long mask=4294967295L;

       //UInt32 temp, temp_1;
       String temp_String ;
      

       cnDelta = 2654435769L;
       sum = 3337565984L;

       nlen = Key.length();
       i = 0;
       for( n = 1 ;n<= nlen ;n=n+2)
       {
           temp_String =Key.substring(n-1, n-1+2); 
           buf[i] =HexToInt(temp_String);
           i = i + 1;
       }
       a = 0 ; b = 0 ; c = 0 ; d = 0;
       for(n = 0;n<=3;n++)
       {
           a = (buf[n] << (n * 8)) | a;
           b = (buf[n + 4] << (n * 8)) | b;
           c = (buf[n + 4 + 4] << (n * 8)) | c;
           d = (buf[n + 4 + 4 + 4] << (n * 8)) | d;
       }


       y = 0;
       z = 0;
       for(n = 0;n<=3;n++)
       {
           temp_2 = conver(inb[n]);
           y = (temp_2 << (n * 8)) | y;
           temp_2 = conver(inb[n + 4]);
           z = (temp_2 << (n * 8)) | z;
       }


       n = 32;

       while (n > 0)
       {
           
           
           temp = (y << 4) & mask;
           temp = (temp + c) & mask;
           temp_1 = (y + sum) & mask;
           temp = (temp ^ temp_1) & mask;
           temp_1 = (y >> 5) & mask;
           temp_1 = (temp_1 + d) & mask;
           temp = (temp ^ temp_1) & mask;
           temp = (z - temp) & mask;
           z = temp & mask;
           /* z += ((y << 4) + c) ^ (y + sum) ^ ((y >> 5) + d); */

           temp = (z << 4) & mask;
           temp = (temp + a) & mask;
           temp_1 = (z + sum) & mask;
           temp = (temp ^ temp_1) & mask;
           temp_1 = (z >> 5) & mask;
           temp_1 = (temp_1 + b) & mask;
           temp = (temp ^ temp_1) & mask;
           temp = (y - temp ) & mask;
           y = temp & mask;
           /*y += ((z << 4) + a) ^ (z + sum) ^ ((z >> 5) + b); */

           sum = (sum-cnDelta)& mask;
           n = n - 1;

       }
       for(n = 0;n<=3;n++)
       {
           outb[n] = (byte)((y >>> (n * 8)) & 255);
           outb[n + 4] =(byte)((z >>> (n * 8)) & 255);
       }
    }
	
	public static void main (String[] args)
	{
		SoftKey mysoftkey = new SoftKey();
		String InString,Outstring,Outstring_2;
		InString="加密锁";
		Outstring=mysoftkey.StrEnc(InString,"1234567890ABCDEF1234567890ABCDEF");
		Outstring_2=mysoftkey.StrDec(Outstring,"1234567890ABCDEF1234567890ABCDEF");
		System.out.println(Outstring);
		System.out.println(Outstring_2);
                
     
	}

}
