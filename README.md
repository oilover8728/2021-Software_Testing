# 2021-Software_Testing Final Project

## - 1. Unit test for File system simulating
使用JAVA實作一個File system架構，並用software testing中unit test的方式來檢查各個功能

## - 2. Motivation
上學期修了作業系統，最後的作業就是實作Linux下的File system，但當時覺得debug很沒效率，而且因為不熟悉Linux，錯誤訊息也發很多時間才搞懂，所以這次就打算用軟體測試課程學到的東西來檢驗File system，算是篇應用向的Test

## - 3. Method
* newFolder
* deleteFolder
* renameFolder
* createFile
* deleteFile
* copyFile
* moveFile
* renameFile

## - 4. Result
* Image show  


* Video show  
[SoftwareTest Demo Video](https://www.youtube.com/watch?v=DAdUgy4v8vU&ab_channel=%E8%AC%9D%E8%87%B3%E6%81%86 "link")

## - 5. Other detail
因為會有錯誤輸入導致資料夾名稱不合法的問題，所以我們是直接寫定資料夾名稱只能是英文和數字的組合，如果不符合就會直接跳出錯誤提醒

## - 6. Exception Testcase
* folder會判斷是不是合法的輸入格式
* 檔名只能是數字和英文的組合
* new folder 已經存在相同檔案
* delete folder 刪除不存在的檔案
* delete folder 刪除不為空的檔案
* rename folder 重新命名不存在的檔案
* rename folder 重新命名成不合法的名稱

* file名稱沒有特別限制
* creat file 已經存在相同檔案
* delete file 不重在的檔案
* rename file 重新命名不存在的檔案
* copy file 複製出一模一樣的檔案
* move file 移動到相同的地方

這些都有列入testcase做測試確定沒有問題

## - 7. Conclusion
這個專題比較困難的地方主要是java中file的處理方式和interaction，如何判斷file的state等等，我在這個專題學到很多相關的操作和function，另外我覺得實際對一個software寫test是很實用也有趣的體驗。


