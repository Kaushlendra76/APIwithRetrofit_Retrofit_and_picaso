# APIwithRetrofit_Retrofit_and_picaso
1. Create a Android project
2. Add RetrofitApi, JSON converter and Picaso Library in the gradle file of the project and Sync
3. Add extention of the kotlin to json data converter so you can easily create the data class in project
4. After creating data class you can create the interface of the Retrofit
5. Create a function for the end point of the API and hit the API using GET annotation in interface
6. Create a Retrofit Api instance and use the all four method of retrofit
7. val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface ::class.java)
8. Hit the API
9. Note internet permission is enable for fecting the data
10. create a adapter class for binding the data and Ui in the application
11. Create a recycler view and text view for the Showing API data in the application.
