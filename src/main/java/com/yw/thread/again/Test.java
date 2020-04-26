package com.yw.thread.again;

import java.io.File;

/**
 * Created by 18765 on 2020/3/20 21:09
 */
public class Test {
    static int iFile = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String dir_str = "D:\\迅雷下载";
        File dir = new File( dir_str );
        clear( dir );
        System.out.println( "清理成功。" );
        System.out.println( "共清理了" + iFile + "个空文件夹" );
    }

    public static void clear( File dir )
    {
        File[] dirs = dir.listFiles();
        for( int i = 0; i < dirs.length; i++ )
        {
            if( dirs[i].isDirectory() )
            {
                clear( dirs[i] );
            }
        }
        if( dir.isDirectory() && dir.delete() )
            iFile++;
        System.out.println( dir + "清理成功" );

    }

}
