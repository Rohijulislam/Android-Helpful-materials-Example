# Coroutine with retrofit example
Necessary files & setup are presented in parent directory.  

### Necessary library files 

   //Kotlin extensions for activity and fragments
   - implementation "androidx.activity:activity-ktx:1.2.3"
   - implementation "androidx.fragment:fragment-ktx:1.3.4"
   
   //LifeCycle
   - implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
   - implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
   - implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.3.1'
   
   //Retrofit
   - implementation 'com.squareup.retrofit2:retrofit:2.6.0'
   - implementation 'com.google.code.gson:gson:2.8.6'
   - implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
   - implementation 'com.squareup.okhttp3:logging-interceptor:3.12.0'
   
### Setting up the View
   
   view model object
   ```kotlin
   private val viewModel : MainViewModel by viewModels()
   ```

Observers Setup
```kotlin
   private fun setupObservers() {
        viewModel.getUsers().observe(this, Observer {
            when(it) {
                is APIResponse.Success -> {
                    Log.e("API", "Data : ${it.data}")
                }

                is APIResponse.Loading -> {
                    Log.e("API", "Loading")
                }

                is APIResponse.Error -> {
                    Log.e("API", "Error : ${it.msg}")
                }
            }
        })

    }
```
### Depreciated Notes
   
ViewModelProviders is officially depreciated & it's no more maintained by google. For details visit the [link]  (https://developer.android.com/reference/android/arch/lifecycle/ViewModelProviders)

### Additonal Resource
1. https://blog.mindorks.com/using-retrofit-with-kotlin-coroutines-in-android
