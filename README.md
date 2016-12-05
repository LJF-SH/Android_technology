# Android_technology

> -  在一个月高风黑的晚上，一个素未谋面的大侠说：“探探”app甚好，每每看到大神作品 致敬经典，心怀崇拜之情，然后在四下无人的时候，注册了账号，开始尝试写写东西。发现了写代码的精髓与速度在于---复制粘贴代码的技巧。

<table>
    <tr>
        <td><font size="3" color="red">人生最重要的两个字在于坚持,别松懈 </td>
    </tr>
</table>


#### 目前还没有团队自己的太多内容，一切都在完善中，我们会抽出业余时间来不断完善更改该内容 
Android开发所需的Android SDK、开发中用到的工具、Android开发教程、Android设计规范，免费的设计素材等：https://github.com/linroid/AndroidDevTools

## 

仅仅为项目中遇到的问题 以及解决办法
---
###项目中可能用到的效果以及常见控件，以及项目中问题 多环境打包 安卓前沿技术等，android   所有所有所有！！！ 有关集合（这个稍微齐全点）项目中需要的效果或者遇到的问题建议现在这个里面查找：https://github.com/Tim9Liu9/TimLiu-Android#%E5%8A%A8%E7%94%BB 还有 http://mp.weixin.qq.com/s?__biz=MzI0NDYzMzg0OQ==&mid=2247483723&idx=1&sn=d86a0d77085a14923a3031d1f3fe86e3&chksm=e95b98ddde2c11cb5ff8dbc867c69e316d1f26f285bc116f0aaa3915f36e5b2e8ea0200a7579&mpshare=1&scene=23&srcid=1112HuJEyFyEzUNjymCyrzdY#rd

---
以及一些优秀的资源学习地 例如：http://www.androidcat.com/?step=3&view=CatFragment

开源项目：banya，Google I/O 2014，Google play music，ZXing，鲁班（图片压缩工具）


恰当的代码编写规范：https://github.com/ribot/android-guidelines/blob/master/project_and_code_guidelines.md

Android Studio中 使用插件会使开发更高效：https://github.com/zzz40500/GsonFormat

---
开发中适配问题：https://github.com/hongyangAndroid/AndroidAutoLayout

缓存问题：https://github.com/JakeWharton/DiskLruCache（内容和图片在从网络上获取到之后都会存入到本地缓存中，因此即使手机在没有网络的情况下依然能够加载出以前浏览过的内容）

开发中log（便于找错）：https://github.com/orhanobut/logger

另一种使用百分比解决：https://github.com/JulienGenoud/android-percent-support-lib-sample

手势：https://github.com/nisrulz/sensey 还有 https://github.com/ikew0ng/SwipeBackLayout



---

开发中可使用的框架：http://mp.weixin.qq.com/s？__biz=MzA3MDMyMjkzNg==&mid=2652261699&idx=1&sn=d9b0514c22062c8f76c828a427d6c40d&scene=23&srcid=0907sSKUJ9GhZzxKJxcIjCy1#rd

动画库：https://github.com/thunderrise/android-TNRAnimationHelper
https://github.com/daimajia/AndroidViewAnimations

状态栏：https://github.com/laobie/StatusBarUtil

一二三级联动：https://github.com/saiwu-bigkoo/Android-PickerView

Android开发人员不得不收集的代码(持续更新中)：https://github.com/Blankj/AndroidUtilCode/blob/master/README-CN.md

android RxAndroid:https://github.com/ReactiveX/RxAndroid

android rx等等:https://github.com/JakeWharton/RxBinding
http://www.cnblogs.com/zhaoyanjun/p/5535651.html

android retroit传送:https://github.com/WuXiaolong/AndroidMVPSample

retrofit 简单参数含义：http://blog.csdn.net/fuhao476200/article/details/52980318

---
开发中可能用到的效果：

http://androidblog.cn/index.php/Source/

http://www.open-open.com/lib/view/open1411443332703.html

----


### demo项目中有完整的框架以及一些问题的解决，正在完善。。。

# 这些都正在筹划中。。。

### 前期为邀请方式
### 项目中的问题1：


>- 一般我们在在布局文件中使用 android:text="昵称" 这样的代码，哦，这里不是说你没有引用string资源，而要说的是，这样写（I am title,2000-0-0，张三）等字段来明显区分布局控件会遇到的问题，我刚开始也是这样写的，等获取数据后再.setText就行了。
但是，天 啊 这样做页面会先显示你在布局文件中写的那些文案，当网络加载十分缓慢时候这些文案又会一直存在，这时候会有一个测试人员立马站起来走到你面前问你，卧槽我这个手机为什么会闪一下别的名字才显示我的昵称这些信息，你们怎么改我的信息了（小羊驼奔腾而过。。。）
 
（在程序员看来这个并不是什么问题，但是运营的人会觉得这会引起部分用户心理恐慌）我想等写完代码后我就把布局里这些东西一并删了不就行了。但是也可能会忘啊，以至于在你的最终产品中也会有这样的代码。
 
tools可以告诉Android Studio，哪些属性在运行的时候 是被忽略的，只在设计布局的时候有效如：tools:text="I am a title"（只在布局预览中能够看到这个属性的值，但是当实际上运行的时候是看不到这个值的）打包时候会忽略这些字段的（也可以用来区别语种不用把手机调成英文的来看效果区别）

扩展：有人会问那布局中tools:context=".MainActivity"有毛用，我把它删了也不影响正常编译啊，啊~恩。。。 大兄弟捏，先别着急啊，听我说 这表示你当前的Layout所在的渲染上下文是activity name对应的那个activity，如果这个activity在manifest文件中设置了Theme，那么ADT的Layout Editor会根据这个Theme来渲染你当前的Layout。仅用于给你看所见即所得的效果而已。这时候会有人站出来了，这还是没卵用，不就是跟上面那个差不多意思么，鸡肋啊 
大兄弟捏 我看你总结的很好呀，其实内，我也这么想滴。（百度会有跟多用法，这里只是一个引子）


----


##这是一个禁用表情图的套件，避免提交信息时发生服务器500的错误，但我们不建议您来使用这个库，因为我们有更好的处理办法，可控制能否表情图输入等功能，这些会在以后更新中完善。目前我们已经停止跟新依赖。
![example](example.jpg)

### Download

-------

Gradle:


```
dependencies {
	compile 'com.github.yk963307153:Android_technologys:V0.0.1'
}
```
如果Sycn Now后不能通过，在最外层Gradle中加入：

```
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

使用方法:

 在xml文件中引入ContainsEmojiEditText

```
<com.team.group.ourlibrary.widget.ContainsEmojiEditText
      android:layout_width="wrap_content"
      android:layout_height="wrap_content" />
      
```
---
添加依赖后出现找不到资源文件的情况参考：http://blog.csdn.net/xuguobiao/article/details/50913390
---
