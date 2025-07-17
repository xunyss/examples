project setting
 - C++ Project
 - Shared Library
 - Toolchain : MinGW GCC

C/C++ General
 - Paths and Symbols
  - Includes
   - GNU C / GNU C++
      Add > D:\xdev\jdk\jdk1.6.0_45\include
      Add > D:\xdev\jdk\jdk1.6.0_45\include\win32

C/C++ Build
 - Settings
  - Tool Setting
   - MinGW C++ Linker
      Command > gcc
   - MinGW C++ Linker > Miscellaneous
      Linker flags > -Wl,-kill-at
