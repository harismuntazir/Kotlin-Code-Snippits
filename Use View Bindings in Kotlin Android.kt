//add below code to the build.gradle of your project at module level
android {
  ....
  buildFeatures {
        viewBinding true
    } 

 
  //then inflate the layout as follows inside your onCreate method
  //make sure your activity name ends with Binding at the end like below
val binding = YourViewNameBinding.inflate(layoutInflater)
//set the layout content view as 
setContentView(binding.root)
