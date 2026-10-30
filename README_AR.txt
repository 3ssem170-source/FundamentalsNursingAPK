مشروع Fundamentals of Nursing I - غلاف Android WebView

ما الذي يفعله هذا المشروع؟
- يفتح صفحة التطبيق المنشورة على GitHub Pages داخل تطبيق Android.
- يسمح بتشغيل JavaScript وDOM Storage لأن التطبيق يستخدم localStorage بالمفتاح nursing_v1.
- تحديث HTML/CSS/JavaScript المنشور على GitHub يظهر للمستخدم عند إعادة تحميل الصفحة، دون إعادة تثبيت APK.

مهم بخصوص العمل دون إنترنت:
هذا الإصدار الأول يعتمد على تحميل الصفحة من الإنترنت. تخزين WebView المؤقت ليس ضمانًا لعمل التطبيق كاملًا دون اتصال. لا تعتبره إصدار Offline نهائيًا.

طريقة استخراج APK:
1. ثبّت Android Studio على الكمبيوتر.
2. فك ضغط المشروع.
3. من Android Studio اختر Open ثم اختر مجلد FundamentalsNursingAPK.
4. وافق على تثبيت Android SDK/Build Tools إذا طلب ذلك، وانتظر Gradle Sync.
5. اختر Build > Build Bundle(s) / APK(s) > Build APK(s).
6. بعد اكتمال البناء اضغط Locate من إشعار Android Studio. ملف debug APK يكون عادة في app/build/outputs/apk/debug/app-debug.apk.

عنوان صفحة الويب مضبوط في MainActivity.java:
https://3ssem170-source.github.io/-/nursing.html

تنبيه:
هذا مشروع أولي غير موقّع بإصدار release. قبل التوزيع الواسع، أنشئ Signed APK من Build > Generate Signed Bundle / APK واحتفظ بمفتاح التوقيع في مكان آمن.
