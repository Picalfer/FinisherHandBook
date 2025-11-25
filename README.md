# FinisherHandbook

[![Kotlin](https://img.shields.io/badge/Kotlin-1.8+-blue.svg?logo=kotlin)](https://kotlinlang.org)
[![Platform](https://img.shields.io/badge/Platform-Android-green.svg?logo=android)](https://www.android.com/)
[![UI](https://img.shields.io/badge/UI-NavigationDrawer-blue.svg)]()

Приложение-справочник с категориями и детальными страницами.

## О проекте

Приложение отображает список элементов (например, виды рыбы), позволяет переключаться между категориями с помощью Navigation Drawer и открывать детальные экраны с описанием. Данные автоматически собираются из ресурсов: массивов строк и массива изображений.

**Основной функционал:**
- Навигация через Navigation Drawer  
- Подгрузка данных из ресурсов (строки + изображения)  
- Динамическое обновление списка через `updateAdapter()`  
- Открытие детального экрана с полной информацией  
- RecyclerView с собственным адаптером  
- Toast-уведомления при взаимодействии

## Технологии

* Kotlin  
* RecyclerView  
* Navigation Drawer  
* Custom Adapter  
* Intent data passing  
* TypedArray image loading  
* LinearLayoutManager  
