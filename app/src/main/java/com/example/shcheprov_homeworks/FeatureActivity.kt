package com.example.shcheprov_homeworks

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.shcheprov_homeworks.databinding.ActivityFeatureBinding
import android.Manifest.permission.CAMERA as CAMERA_PERMISSION

class FeatureActivity : AppCompatActivity() {
    private val binding: ActivityFeatureBinding by lazy {
        ActivityFeatureBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        handlePermissions(CAMERA_PERMISSION, checkPermissions(CAMERA_PERMISSION))
        binding.startCameraButton.setOnClickListener {
            startCamera()
        }
    }

    private fun handlePermissions(
        permission: String,
        checkPermissionsResult: CheckPermissionsResult
    ) {
        when (checkPermissionsResult) {
            CheckPermissionsResult.GRANTED -> setButtonEnabled()
            CheckPermissionsResult.DENIED -> showFailurePermissionsRequestDialog()
            CheckPermissionsResult.NEED_TO_EXPLAIN -> showExplainPermissonsDialog()
            CheckPermissionsResult.NEED_TO_REQUEST -> requestPermissionLauncher.launch(permission)
        }
    }

    private fun startCamera() {
        try {
            startActivity(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        } catch (e: Exception) {
        }
    }

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                setButtonEnabled()
                startCamera()
            } else {
                showFailurePermissionsRequestDialog()
            }
        }

    private fun setButtonEnabled() {
        binding.startCameraButton.apply {
            isEnabled = true
            text = getString(R.string.turn_on_camera)
        }
    }

    private fun showExplainPermissonsDialog() {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.need_permissons))
            .setMessage(getString(R.string.camera_permissons_explain))
            .setPositiveButton(getString(R.string.ok)) { _, _ ->
                requestPermissionLauncher.launch(CAMERA_PERMISSION)
            }.show()
    }

    private fun showFailurePermissionsRequestDialog() {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.need_permissons))
            .setMessage(getString(R.string.you_denied_permisson))
            .setPositiveButton(getString(R.string.i_change_my_mind)) { _, _ ->
                requestPermissionLauncher.launch(CAMERA_PERMISSION) }
            .setNegativeButton(getString(R.string.i_understand), null)
            .show()
    }

    private fun checkPermissions(permission: String): CheckPermissionsResult {
        return when {
            (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) -> CheckPermissionsResult.GRANTED
            ContextCompat.checkSelfPermission(
                this, permission
            ) == PackageManager.PERMISSION_GRANTED -> CheckPermissionsResult.GRANTED
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && shouldShowRequestPermissionRationale(
                permission
            ) -> CheckPermissionsResult.NEED_TO_EXPLAIN
            else -> CheckPermissionsResult.NEED_TO_REQUEST
        }

    }

    enum class CheckPermissionsResult {
        GRANTED,
        DENIED,
        NEED_TO_REQUEST,
        NEED_TO_EXPLAIN
    }

}