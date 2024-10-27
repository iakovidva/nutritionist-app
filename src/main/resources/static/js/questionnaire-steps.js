
let currentStep = 1;
const totalSteps = 9;

function showStep(step) {
    document.querySelectorAll('.step').forEach((el) => el.classList.remove('active'));
    document.getElementById(`step-${step}`).classList.add('active');
}

function nextStep() {
    if (validateStep(currentStep)) {
        if (currentStep < totalSteps) {
            currentStep++;
            showStep(currentStep);
            updateProgressBar();
        }
    }
}

function previousStep() {
    if (currentStep > 1) {
        currentStep--;
        showStep(currentStep);
        updateProgressBar();
    }
}

function validateStep(stepNumber) {
    let isValid = true;

    // Get all input fields of the current step
    const step = document.getElementById('step-' + stepNumber);
    const inputs = step.querySelectorAll('input, select, textarea');

    // Loop through the inputs and validate
    inputs.forEach((input) => {
        if (!input.checkValidity()) {
            isValid = false;
            input.classList.add('is-invalid'); // Add Bootstrap class for invalid fields
        } else {
            input.classList.remove('is-invalid');
        }
    });
    return isValid;
}

// Initialize the first step
document.addEventListener("DOMContentLoaded", function() {
    showStep(currentStep);
    updateProgressBar();
});

function updateProgressBar() {
    const progress = (currentStep / totalSteps) * 100;
    const progressBar = document.querySelector('.progress-bar');
    progressBar.style.width = progress + '%';
    progressBar.setAttribute('aria-valuenow', currentStep);
}

