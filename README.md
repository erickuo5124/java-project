# 慧貞大戰中國武漢病毒
### 知識是光，善良是影

HackMD 連結：https://hackmd.io/@kuouu/Java

GitHub 連結：https://github.com/erickuo5124/fight_covid19


---

## 遊戲規則

「知識是光，善良是影，公民責任是教養和承擔。」
面對新型冠狀病毒的來襲，成大也不得不做好準備
收集從書本中得到的知識之光
用口罩來抵禦病毒，並用酒精消滅它們
防疫高手，就是你我

---

## UI
場地：3*10

![](https://i.imgur.com/H9FEpo6.jpg)
![](https://i.imgur.com/ymmQIl8.jpg)
![](https://i.imgur.com/XNu4fUB.jpg)
![](https://i.imgur.com/NnqzLSD.jpg)


---

## 角色

### 成大（家）
校長
成大可撥學生*3

### 防疫措施（植物）
![](https://i.imgur.com/VmlrKix.gif)

| Name | HP | ATK | Cost |speed| 說明 |
| - | - | - | - | - | - |
| Book(書本)![](https://i.imgur.com/wxOQNri.gif)| 30 | 0 | 50 |0| 收集知識之光![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/sun.png?raw=true)(yield:30/6秒)|
| Alcohol(酒精瓶)![](https://i.imgur.com/apmPAp3.gif)|50|10|100|1|射出一滴酒精(Bullet)![](https://i.imgur.com/YLtkTos.png)，最廢的那種|
|mask(口罩)![](https://i.imgur.com/yl2pK8Z.gif)|100|0|50|0|牆壁，很硬|
|額溫槍![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/plants/freezepeashooter.gif?raw=true)|50|10|150|1|緩速為一半緩速5秒![](https://github.com/arminkz/PlantsVsZombies/blob/master/src/images/freezepea.png?raw=true)|
|QRcode![](https://i.imgur.com/KKcUKc4.png)![](https://i.imgur.com/c6ybIKH.png)|10|$\infty$|150|0|消掉三格距離內殭屍|


5秒 多10個知識之光
子彈：一秒一格



### 病毒（殭屍）

| Name | HP | ATK |speed| 
| - | - | - | - |
|Normal_virus![](https://i.imgur.com/o0Sw5V8.gif)|40|10|4|
|Strong_virus![](https://i.imgur.com/0kll6yh.gif)|100|10|4|
|會噴絲的瞬移病毒 ![](https://i.imgur.com/aiznaTT.png)|50|10|原地等8秒直接瞬移到最前線|

抓抓：一秒一下


---

## 程式架構

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

## patch

```java=
public void dead() {
	if(!super.getname().equals("E") && this.getHP() <= 0) {
		Core.plant.get(this.getY()).set(this.getX(),new EmptyP(this.getY(),this.getX()));
	}
}
```