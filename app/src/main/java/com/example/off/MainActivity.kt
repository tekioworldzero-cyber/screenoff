package com.example.off

import android.app.Activity
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dpm: DevicePolicyManager
    private lateinit var compName: ComponentName

    private val requestAdminLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "Administrador activado", Toast.LENGTH_SHORT).show()
            updateStatus()
        } else {
            Toast.makeText(this, "No se activó el administrador", Toast.LENGTH_SHORT).show()
            updateStatus()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dpm = getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
        compName = ComponentName(this, MyDeviceAdminReceiver::class.java)

        val btnLock = findViewById<Button>(R.id.btn_lock)
        val tvStatus = findViewById<TextView>(R.id.tv_status)

        btnLock.setOnClickListener {
            if (dpm.isAdminActive(compName)) {
                dpm.lockNow()
            } else {
                val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN)
                intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, compName)
                intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                    "Activa el administrador para permitir que la app apague/bloquee la pantalla.")
                requestAdminLauncher.launch(intent)
            }
        }

        updateStatus()
    }

    private fun updateStatus() {
        val tvStatus = findViewById<TextView>(R.id.tv_status)
        val active = dpm.isAdminActive(compName)
        tvStatus.text = "Estado: " + if (active) "Administrador activo" else "No activo"
    }
}
