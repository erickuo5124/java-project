# 惠貞大戰中國武漢病毒
### 知識是光，善良是影

HackMD 連結：https://hackmd.io/@kuouu/Java

GitHub 連結：https://github.com/erickuo5124/java-project

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
| 書本![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/plants/sunflower.gif?raw=true) | 30 | 0 | 50 |0| 收集知識之光![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/sun.png?raw=true)(yield:30/6秒)|
| 酒精瓶![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/plants/peashooter.gif?raw=true) |50|10|100|1|射出一滴酒精![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/pea.png?raw=true)，最廢的那種|
|口罩![](https://vignette.wikia.nocookie.net/plantsvszombies/images/f/f8/2zfsax5_th.gif/revision/latest?cb=20110903004407)|100|0|50|0|牆壁，很硬|
|額溫槍![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/plants/freezepeashooter.gif?raw=true)|50|10|150|1|緩速為一半緩速5秒![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/freezepea.png?raw=true)|
|QRcode![](https://vignette.wikia.nocookie.net/plantsvszombies/images/4/4b/PvZ_Pictures.doc2.png/revision/latest?cb=20111123191552 =91x69)![](https://i.imgur.com/NlsGNiJ.png =180x148)|10|$\infty$|150|0|消掉三格距離內殭屍|

:::info
5秒 多10個知識之光
子彈：一秒一格
:::


### 病毒（殭屍）

| Name | HP | ATK |speed| 
| - | - | - | - |
|中國武漢病毒![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/zombies/zombie1.png?raw=true)|40|10|4|
|有蛋白質殼的病毒![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/zombies/zombie2.png?raw=true)|100|10|4|
|會噴絲的瞬移病毒 ![](https://vignette.wikia.nocookie.net/plantsvszombies/images/2/21/PoleZombie2009HD.png/revision/latest?cb=20170905234524 =110x90)|50|10|原地等8秒直接瞬移到最前線|

:::info
抓抓：一秒一下
:::

---

## 程式架構

|funcName|return|parameter|內容|
|-|-|-|-|
|example|(int)location|(virus)virus|取得輸入virus的座標|

![](https://i.imgur.com/akKLBkG.png)

---

## reference
[plants vs zombies](https://github.com/arminkz/PlantsVsZombies)

---

:::warning
可能會做，可能不會做 (八成是不會)
:::

---

## 道具
1. 鏟子

---