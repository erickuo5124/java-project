# 惠貞大戰中國武漢病毒
### 知識是光，善良是影

HackMD 連結：https://hackmd.io/@kuouu/Java

GitHub 連結：https://github.com/erickuo5124/fight_covid19


---

## 遊戲機制
各個物件有生命值和攻擊力

生命值歸零就消失

如果病毒走到城堡就遊戲結束

殺病毒就加分

沒有破關條件只最高

---

## UI
場地：3*10
![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/mainBG.png?raw=true)
![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/cards/card_cherrybomb.png?raw=true)![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/cards/card_freezepeashooter.png?raw=true)![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/cards/card_peashooter.png?raw=true)![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/cards/card_sunflower.png?raw=true)![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/cards/card_wallnut.png?raw=true)

---

## 角色

### 成大（家）
校長
成大可撥學生*3

### 防疫措施（植物）

| Name | HP | ATK | Cost |speed| 說明 |
| - | - | - | - | - | - |
| Book(書本)![](https://media.tenor.com/images/8ef57505dca09c4c4df3766faa3f5aca/tenor.gif =125x) | 30 | 0 | 50 |0| 收集知識之光![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/sun.png?raw=true)(yield:30/6秒)|
| Alcohol(酒精瓶)![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/plants/peashooter.gif?raw=true) |50|10|100|1|射出一滴酒精(Bullet)![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/pea.png?raw=true)，最廢的那種|
|口罩![](https://vignette.wikia.nocookie.net/plantsvszombies/images/f/f8/2zfsax5_th.gif/revision/latest?cb=20110903004407)|100|0|50|0|牆壁，很硬|
|額溫槍![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/plants/freezepeashooter.gif?raw=true)|50|10|150|1|緩速為一半緩速5秒![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/freezepea.png?raw=true)|
|QRcode![](https://i.imgur.com/KKcUKc4.png)![](https://i.imgur.com/c6ybIKH.png)|10|$\infty$|150|0|消掉三格距離內殭屍|


5秒 多10個知識之光
子彈：一秒一格



### 病毒（殭屍）

| Name | HP | ATK |speed| 
| - | - | - | - |
|中國武漢病毒![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/zombies/zombie1.png?raw=true)|40|10|4|
|有蛋白質殼的病毒![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/zombies/zombie2.png?raw=true)|100|10|4|
|會噴絲的瞬移病毒 ![](https://i.imgur.com/aiznaTT.png)
|50|10|原地等8秒直接瞬移到最前線|

抓抓：一秒一下


---

## 程式架構

|funcName|return|parameter|內容|
|-|-|-|-|
|example|(int)location|(virus)virus|取得輸入virus的座標|


### 構想
![](https://i.imgur.com/akKLBkG.png)

### 實際
![](https://i.imgur.com/walouxp.png)



---

## Core

### 物件管理
用三個3 * 10的陣列管理畫面上的物件

宣告於core最上面

UI只要偵測這些陣列去顯示即可

```java=
static ArrayList<ArrayList<Plants>> plant = new ArrayList<ArrayList<Plants>>(3);
static ArrayList<ArrayList<Virus>> virus = new ArrayList<ArrayList<Virus>>(3);
static ArrayList<ArrayList<Bullet>> bullet = new ArrayList<ArrayList<Bullet>>(3);
```
分別是植物、病毒、投射物

顯示"E"代表是空的狀態
![](https://i.imgur.com/5qs9yRU.png)

#### 植物
"A":酒精

"M":口罩

"B":書本
#### 病毒
"N":普通病毒

"S":帶殼病毒

#### 投射物
"N":普通子彈

### 計時器
Core有四個計時器

suntimer負責每五秒增加基本陽光10

virustimer負責每五秒生成殭屍在最右邊

detectiontimer負責每秒偵測是否有殭屍走到左邊終點以及讓殭屍卡在植物面前時攻擊植物

repainttimer負責每秒更新三個物件陣列

### 物件重疊問題
因為只用了二維陣列

相同種類物件重疊時會記錄不到

但可以靠疊加屬性或的相同效果

ex:兩隻殭屍在同一格->其中一隻繼承另一隻的血量和攻擊力



---

## reference
[plants vs zombies](https://github.com/arminkz/PlantsVsZombies)

---

可能會做，可能不會做 (八成是不會)

---

## 道具
1. 鏟子

---