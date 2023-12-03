<template>
<form>
  <!-- Name Field -->
  <div class="mb-3">
    <label for="inputName" class="form-label">Name</label>
    <input type="text" class="form-control" id="inputName" placeholder="Enter name">
  </div>

  <!-- Description Field -->
  <div class="mb-3">
    <label for="inputDescription" class="form-label">Description</label>
    <textarea class="form-control" id="inputDescription" rows="3" placeholder="Enter description"></textarea>
  </div>

<!-- Date and Time Field -->
<div class="mb-3">
    <label for="inputLocation" class="form-label">Date and Time</label>
    <input type="text" class="form-control" id="inputLocation" placeholder="Enter date and time">
  </div>

  <!-- Location Field -->
  <div class="mb-3">
    <label for="inputLocation" class="form-label">Location</label>
    <input type="text" class="form-control" id="inputLocation" placeholder="Enter location">
  </div>

  <!-- Submit Button -->
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</template>

<script>
export default {

}
</script>

<style>

</style>