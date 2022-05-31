package com.example.newpage

data class Diseases(var id : Int,
                    var name: String,
                    var data_updated_at : String,
                    var symptoms : String,
                    var facts: List<String>)
