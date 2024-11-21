package com.example.mvvmroomdatabasedaggerhiltpractice.ui.activity

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import com.example.mvvmroomdatabasedaggerhiltpractice.R
import com.example.mvvmroomdatabasedaggerhiltpractice.databinding.ActivityCreateInboundOrderBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.base.BaseActivity
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.fragments.QualityCheckFragment
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@AndroidEntryPoint
class CreateInboundOrderActivity : BaseActivity<ActivityCreateInboundOrderBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setToolbar(getString(R.string.str_create_inbound))
    }

    override fun inflateBinding() = ActivityCreateInboundOrderBinding.inflate(layoutInflater)

    override fun bindViewData() {
        setDatePicker()

    }

    private fun setDatePicker() {
        val currentDate = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        binding.edtSelectedDate.setText(dateFormat.format(currentDate.time))

        binding.edtSelectedDate.setOnClickListener {
            showDatePicker()
        }

    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()

        val datePicker = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                // Update TextInputEditText with selected date
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                binding.edtSelectedDate.setText(dateFormat.format(selectedDate.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        // Set minimum date to today to disable past dates
        datePicker.datePicker.minDate = calendar.timeInMillis
        datePicker.show()
    }

    override fun setOnclickListeners() {
        binding.toolbar.ivBack.setOnClickListener {
            startActivity(Intent(this, OrdersActivity::class.java))
            finish()
        }
        binding.btnSubmit.setOnClickListener {
            startActivity(Intent(this,ViewInboundOrdersActivity::class.java))
            finish()
        }
    }

    override fun observeData() {
    }
}