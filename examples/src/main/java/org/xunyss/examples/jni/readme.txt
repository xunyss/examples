# 참고사이트
 - http://www.ntu.edu.sg/home/ehchua/programming/java/JavaNativeInterface.html

# .h 파일생성
 - External Tool 설정
   Location
     D:\xdev\jdk\jdk1.6.0_45\bin\javah.exe
   Working Derectory
     ${workspace_loc:/JniCreator}/bin
   Arguments
     -d ${workspace_loc:/JniCreator}/jni-header ${string_prompt}

# dll 개발/생성
 - cppApp 이용하여 개발
 - 생성된 .dll 파일을 lib 디렉토리로 복사

# 테스트
 - Project Properties 설정
   Java Build Path > Source > Native library location
   lib 디렉토리 추가


** 그 밖에 native api / COM+ 를 제어할 수 있는 방법.
1. jna   (https://github.com/twall/jna)
2. jacob (http://sourceforge.net/projects/jacob-project/)
3. com4j (http://com4j.kohsuke.org/)
