

export const convertDateToDateTimeLocal = (dateString) => {
    const parts = dateString.split('-');
  if (parts.length === 3) {
    const year = parseInt(parts[0]);
    const month = parseInt(parts[1]) - 1; // Months are 0-indexed
    const day = parseInt(parts[2]);
    return new Date(year, month, day);
  } else {
    throw new Error('Invalid date format');
  }

};